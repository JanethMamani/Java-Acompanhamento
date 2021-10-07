use tabelareploid;

SELECT seller.*,department.Name as Departamento
FROM seller INNER JOIN department
ON seller.DepartmentId = department.Id
WHERE seller.Id = 3