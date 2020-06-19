# a) Which customers are in a different city than their sales representative?

SELECT customers.customerNumber,customers.customerName from customers
JOIN employees on customers.salesRepEmployeeNumber = employees.employeeNumber
where customers.city <> (select offices.city from offices where employees.officeCode = offices.officeCode);

# b) Which orders included sales that are below the manufacturer’s suggested retail price(MSRP)?

select orders.orderNumber,orderdetails.priceEach as Sale ,products.MSRP FROM orders
INNER JOIN orderdetails on orders.orderNumber = orderdetails.orderNumber
INNER JOIN products on orderdetails.productCode = products.productCode
where orderdetails.priceEach < products.MSRP
group by orderdetails.orderNumber;

# c) List the top 5 products for 2004 with the highest average mark-up percentage per order.Include the mark-up. The mark-up is the ratio of (sale price – cost) and cost.

SELECT products.productCode,products.productName, avg(((orderdetails.priceEach - products.buyPrice)/products.buyPrice)*100) as AverageMarkup FROM orderdetails
INNER JOIN products on orderdetails.productCode = products.productCode
INNER JOIN orders on orders.orderNumber = orderdetails.orderNumber
where orders.orderDate like '2004%'
group by orderdetails.productCode
order by AverageMarkup DESC
limit 5 ;

# d) List the top 3 employees with the greatest average diversity of products in their orders.

select  a.emp , a.fName,a.sName, avg(a.avgdiv) as AverageDiversity from 
(SELECT employees.employeeNumber as emp, employees.firstName as fName, employees.lastName as sName,  count(distinct(orderdetails.productCode)) as avgdiv FROM employees
Inner Join customers on customers.salesRepEmployeeNumber = employees.employeeNumber
Inner join orders on orders.customerNumber = customers.customerNumber
Inner join orderdetails on orderdetails.orderNumber = orders.orderNumber
group by orderdetails.orderNumber
order by avgdiv desc
) a  group by a.emp order by AverageDiversity desc limit 3;

# e) What is the average time needed to ship orders from each office in 2005, relative to the order date?
Select offices.officeCode,offices.city,avg(DATEDIFF(orders.shippedDate, orders.orderDate)) as Shipping_Time from orders
INNER JOIN customers on orders.customerNumber = customers.customerNumber
INNER JOIN employees on customers.salesRepEmployeeNumber = employees.employeeNumber
INNER JOIN offices on employees.officeCode = offices.officeCode
where orders.orderDate like "2005%"
group by offices.city
order by offices.officeCode asc;