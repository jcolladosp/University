;; =========================================================
;; ===               BULB REPLACER ROBOT                ====
;; =========================================================

(deffacts bulb-robot
	(grid 5 4)
	(warehouse 2 3)
	(tunnel 2 3 4 2)
	(tunnel 4 2 2 3)
	(max-bulb 3)
	(robot 1 3 0 lamp 3 4 3 lamp 4 2 2 lamp 5 4 2 level 0)
	(depth 100)
	
	)
	
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

(defrule take-tunnel
	?f<-(robot ?x ?y ?z $?q level ?level)
	(tunnel ?x ?y ?xa ?ya)
	(depth ?d)
	(test (<= ?level ?d ))
 =>
	(assert (robot ?xa ?ya ?z $?q level (+ ?level 1))))	
	
(defrule solution
	(declare (salience 100))
	?f<-(robot ? ? ? level ?level)
	(depth ?d)
	(test (<= ?level ?d ))
 =>
    (printout t "SOLUTION FOUND AT LEVEL " ?level crlf)
    (halt))	

(defrule nosolution
(declare (salience -99))
	?f<-(robot ? ? ? $? lamp ? ? ? $? level ?level)
	(depth ?d)
	(test(> ?level ?d))
 =>
    (printout t "SOLUTION NOT FOUND" crlf)
	(halt)) 