SELECT Q.qcode,Q.wording
FROM QUERY Q
WHERE 2 < (SELECT COUNT(N.tname)
			FROM Needs N
			WHERE N.qcode = Q.code
			GROUP BY N.qcode)
AND 1 < (SELECT COUNT(S.stid)
			FROM SOLVE S
			WHERE S.qcode = Q.qcode
			GROUP BY S.qcode)



SELECT tname
FROM  NEEDS
GROUP BY name
HAVING COUNT(n.qcode) >= ALL (SELECT COUNT(qcode)
								FROM NEEDS
								GROUP BY tname)


SELECT A.stid, A.name, COUNT(R.qcode),SUM(R.time)
FROM STUDENT A LEFT JOIN SOLVERS R ON A.stid = R.stid


