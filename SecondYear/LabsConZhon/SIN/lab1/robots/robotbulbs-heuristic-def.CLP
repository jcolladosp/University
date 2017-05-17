;; =========================================================
;; ===           BULB REPLACER ROBOT HEURISTIC          ====
;; =========================================================

(defglobal ?*f* = 1)

(deffunction start ()
	(set-salience-evaluation when-activated)
	(reset)
	(printout t "Maximum depth:= " )
	(bind ?prof (read))
	(printout t " Execute run to start the program " crlf)
	(assert (robot 1 3 0 lamp 3 4 3 lamp 4 2 2 lamp 5 4 2 level 0))
	(assert (depth ?prof))
	(assert (max-bulb 3))
	(assert (warehouse 2 3))
	(assert (grid 5 4))
)


;============================================================
;================== HEURISTIC FUNCTIONS =====================
;============================================================

(deffunction manhattan (?x ?y ?xx ?yy)
	(bind ?dist (+ (abs(- ?x ?xx))(abs(- ?y ?yy))))
	?dist
)

(deffunction movesrema (?x ?y ?z ?wx ?wy ?lp)
	(bind ?mov 0)
	(bind ?index 1)
	(if(= (length$ ?lp) 0 ) 
	then
		(bind ?mov 0) 
	else
		(if(<> ?z 3) 
		then 
			(bind ?mov (+ ?mov (manhattan ?x ?y ?wx ?wy) 1))
		)
	
		(if(and (= ?z 3)(> (length$ ?lp) (+ ?index 4))) 
		then 
			(bind ?mov (+ ?mov  (manhattan ?x ?y (nth$ (+ ?index 1) ?lp) (nth$ (+ ?index 2) ?lp))  1 ))
			(bind ?mov (+ ?mov (manhattan ?wx ?wy (nth$ (+ ?index 1) ?lp) (nth$ (+ ?index 2) ?lp))1 ))
			(bind ?index (+ ?index 4))
		)		
	
		(while (> (length$ ?lp) (+ ?index 4))
			(bind ?mov (+ ?mov  (*(manhattan ?wx ?wy (nth$ (+ ?index 1) ?lp) (nth$ (+ ?index 2) ?lp)) 2)2))
			(bind ?index (+ ?index 4))
		)	
		(bind ?mov (+ ?mov  (manhattan ?x ?y (nth$ (+ ?index 1) ?lp) (nth$ (+ ?index 2) ?lp)) 1  ))
	)
	?mov
)

(deffunction control (?x ?y ?z ?wx ?wy ?lp ?level)
    (bind ?*f* (movesrema ?x ?y ?z ?wx ?wy ?lp))
    (bind ?*f* (+ ?*f* ( + ?level 1)))
)


;============================================================
;================== MOVEMENT FUNCTIONS ======================
;============================================================
	
(defrule left
	(declare (salience (- 0 ?*f*)))
	?f<-(robot ?x ?y ?z $?q level ?level)
	(depth ?d)
	(test (<= ?level ?d ))
	(test (> ?x 1))
	(warehouse ?wx ?wy)
	(test (control ?x ?y ?z ?wx ?wy $?q ?level))
 =>
	(assert (robot (- ?x 1) ?y ?z $?q level (+ ?level 1))))
	
(defrule right
	(declare (salience (- 0 ?*f*)))
	?f<-(robot ?x ?y ?z $?q level ?level)
	(grid ?a ?b)
	(depth ?d)
	(test (<= ?level ?d ))
	(test (< ?x ?a))
	(warehouse ?wx ?wy)
	(test (control ?x ?y ?z ?wx ?wy $?q ?level))
 =>
	(assert (robot (+ ?x 1) ?y ?z $?q level (+ ?level 1))))
	
(defrule up
	(declare (salience (- 0 ?*f*)))
	?f<-(robot ?x ?y ?z $?q level ?level)
	(grid ?a ?b)
	(depth ?d)
	(test (<= ?level ?d ))
	(test (< ?y ?b))
	(warehouse ?wx ?wy)
	(test (control ?x ?y ?z ?wx ?wy $?q ?level))
 =>
	(assert (robot ?x (+ ?y 1) ?z $?q level (+ ?level 1))))
	
(defrule down
	(declare (salience (- 0 ?*f*)))	
	?f<-(robot ?x ?y ?z $?q level ?level)
	(depth ?d)
	(test (<= ?level ?d ))
	(test (> ?y 1))
	(warehouse ?wx ?wy)
	(test (control ?x ?y ?z ?wx ?wy $?q ?level))
 =>
	(assert (robot ?x  (- ?y 1) ?z $?q level (+ ?level 1))))

(defrule load-bulb
	(declare (salience (- 0 ?*f*)))
	?f<-(robot ?x ?y ?z $?q level ?level)
	(warehouse ?x ?y)
	(max-bulb ?bomb)
	(depth ?d)
	(test (<= ?level ?d ))
	(test(< ?z ?bomb))
	(test (control ?x ?y ?z ?x ?y $?q ?level))
	;(test (control ?x ?y ?bomb ?x ?y $?q ?level))
 =>
	(assert (robot ?x  ?y ?bomb $?q level (+ ?level 1))))

(defrule replace-bulb
	(declare (salience (- 0 ?*f*)))	
	?f<-(robot ?x ?y ?z $?q lamp ?x ?y ?bb $?r level ?level)
	(depth ?d)
	(test (<= ?level ?d ))
	(test(>= ?z ?bb))
	(warehouse ?wx ?wy)
	(test (control ?x ?y ?z ?wx ?wy (create$ $?q lamp ?x ?y ?bb $?r) ?level))
	;(test (control ?x ?y ?z ?wx ?wy (create$ $?q $?r) ?level))
 =>
	(assert (robot ?x  ?y (- ?z ?bb) $?q $?r level (+ ?level 1))))	
	
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