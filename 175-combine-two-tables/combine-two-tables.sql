# Write your MySQL query statement below
 
 
SELECT
P.firstName,
p.lastName,
a.city,
a.state
From Person p
LEFT JOIN Address a
On p.personID = a.personID;
