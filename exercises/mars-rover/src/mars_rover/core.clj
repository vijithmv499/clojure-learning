(ns mars-rover.core)
(defn turn-left [[a b c]]
	(
		let [left_map {"N" "W", "W" "S", "S" "E", "E" "N"}]
		[a b (get left_map c)]	
	)
)

(defn turn-right [[a b c]]
	(
		let [right_map {"N" "E", "E" "S", "S" "W", "W" "N"}]
		[a b (get right_map c)]	
	)
)

(defn move [[a b c]]
	(cond
  		(= c "E") [(inc a) b "E"]
  		(= c "N") [a (inc b) "N"]
  		(= c "W") [(dec a) b "W"]
  		(= c "S") [a (dec b) "S"]
	)
)

(defn take-move [[a b c d]]

	(cond
		(= d "L") (turn-left [a b c])
		(= d "R") (turn-right [a b c])
		(= d "M") (move [a b c])
	)
)

(defn start-navigate [[a b c] d]
	; (loop d
	(if(= (empty? d) true)
		[a b c]
		(start-navigate (take-move [a b c (last d)]) (pop d))
	)
	 ; )
)

(defn navigate [[a b c] d]
	(if(= (re-matches #"[LRM]*" d) nil)
		false
		(start-navigate [a b c] (vec (reverse (clojure.string/split d #""))))	
	)
)






