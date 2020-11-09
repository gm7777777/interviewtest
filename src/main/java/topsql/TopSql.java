package topsql;

public class TopSql {

//    SELECT
//    a.class,
//    a.score
//            FROM
//    student a
//    WHERE
//            (
//                    SELECT
//                            count(*)
//    FROM
//            student
//    WHERE
//    a.class = class
//    AND a.score < score
//    ) < 3
//    ORDER BY
//    a.class,
//    a.score DESC;
//
//    select a.class,a.score from student a where (select count(*) from student where a.class=class and a.score<score)<3
//    order by a.class, a.score desc;
}
