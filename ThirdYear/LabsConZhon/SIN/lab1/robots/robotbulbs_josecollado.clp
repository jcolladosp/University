;; =========================================================
;; ===               BULB REPLACER ROBOT                ====
;; =========================================================

(deffacts bulb-robot
	(grid 5 4)
	(warehouse 2 3 B)
	(warehouse 4 1 R)
	(max-bulb 3)
	(robot 1 3 0 B lamp 3 4 3 B lamp 4 2 2 R lamp 5 4 2 B level 0)
	(depth 100)
	
	)

(defrule load-bulb
	?f<-(robot ?x ?y ?z $?q level ?level)
	(warehouse ?x ?y)
	(max-bulb ?bomb)
	(depth ?d)
	(test (<= ?level ?d ))
	(test(< ?z ?bomb))
 =>
	(assert (robot ?x  ?y ?bomb $?q level (+ ?level 1))))

(defrule replace-bulb
	?f<-(robot ?x ?y ?z $?q lamp ?x ?y ?bb $?r level ?level)
	(depth ?d)
	(test (<= ?level ?d ))
	(test(>= ?z ?bb))
 =>
	(assert (robot ?x  ?y (- ?z ?bb) $?q $?r level (+ ?level 1))))	
	
(defrule left
	?f<-(robot ?x ?y ?z $?q level ?level)
	(depth ?d)
	(test (<= ?level ?d ))
	(test (> ?x	1))
	
 =>
	(assert (robot (- ?x 1) ?y ?z $?q level (+ ?level 1))))
	
(defrule right
	?f<-(robot ?x ?y ?z $?q level ?level)
	(grid ?a ?b)
	(depth ?d)
	(test (<= ?level ?d ))
	(test (< ?x	?a))
 =>
	(assert (robot (+ ?x 1) ?y ?z $?q level (+ ?level 1))))
	
(defrule up
	?f<-(robot ?x ?y ?z $?q level ?level)
	(grid ?a ?b)
	(depth ?d)
	(test (<= ?level ?d ))
	(test (< ?y	?b))
 =>
	(assert (robot ?x (+ ?y 1) ?z $?q level (+ ?level 1))))
	
(defrule down
	?f<-(robot ?x ?y ?z $?q level ?level)
	(depth ?d)
	(test (<= ?level ?d ))
	(test (> ?y	1))
 =>
	(assert (robot ?x  (- ?y 1) ?z $?q level (+ ?level 1))))

<<<<<<< HEAD:SIN/Lab2/robotbulbs_josecollado.clp
(defrule load-bulb
	?f<-(robot ?x ?y ?z ?c $?q level ?level)
	(warehouse ?x ?y ?cc)
	(max-bulb ?bomb)
	(depth ?d)
	(test (<= ?level ?d ))
	(test(< ?z ?bomb))
 =>
	(assert (robot ?x  ?y ?bomb ?cc $?q level (+ ?level 1))))
	

(defrule replace-bulb
	?f<-(robot ?x ?y ?z ?c $?q lamp ?x ?y ?bb ?cc $?r level ?level)
	(depth ?d)
	(test (<= ?level ?d ))
	(test(>= ?z ?bb))
	(test (eq ?c ?cc))
 =>
	(assert (robot ?x  ?y (- ?z ?bb) ?c $?q $?r level (+ ?level 1))))	
=======
>>>>>>> d57e225ac2e0e484ab8f3e34a286742c767b918b:SIN/Lab2/robotbulbs.clp
	
(defrule solution
	(declare (salience 100))
	?f<-(robot ? ? ? ? level ?level)
	(depth ?d)
	(test (<= ?level ?d ))
 =>
    (printout t "SOLUTION FOUND AT LEVEL " ?level crlf)
    (halt))	

(defrule nosolution
	(declare (salience -99))
	?f<-(robot ? ? ? ? $? lamp ? ? ? $? level ?level)
	(depth ?d)
	(test(> ?level ?d))
 =>
    (printout t "SOLUTION NOT FOUND" crlf)
    (halt))	
	
	