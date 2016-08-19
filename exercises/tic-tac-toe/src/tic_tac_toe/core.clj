(ns tic-tac-toe.core)

(defn horizontal-match [[a b c]]
	(cond 
		(= true (apply = a)) (a 0)
		(= true (apply = b)) (b 0)
		(= true (apply = c)) (c 0)
		:else false
	)
	
)

(defn vertical-match [[a b c]]
	(cond
		(= true (apply = [(a 0) (b 0) (c 0)])) (a 0)
		(= true (apply = [(a 1) (b 1) (c 1)])) (a 1)
		(= true (apply = [(a 2) (b 2) (c 2)])) (a 2)
		:else false
	)
)

(defn diagonal-match [[a b c]]
	(cond
		(= true (apply = [(a 0) (b 1) (c 2)])) (a 0)
		(= true (apply = [(a 2) (b 1) (c 0)])) (a 2)
		:else false
	)
)

(defn game-winner [[a b c]]
	(cond
		(not= false (horizontal-match [a b c])) (horizontal-match [a b c])
		(not= false (vertical-match [a b c])) (vertical-match [a b c])
		(not= false (diagonal-match [a b c])) (diagonal-match [a b c])
	)
)
