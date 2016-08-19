(ns mars-rover.core)
(defn turn-left [[x y dir]]
	(
		let [left_map {"N" "W", "W" "S", "S" "E", "E" "N"}]
		[x y (get left_map dir)]	
	)
)

(defn turn-right [[x y dir]]
	(
		let [right_map {"N" "E", "E" "S", "S" "W", "W" "N"}]
		[x y (get right_map dir)]	
	)
)

(defn move [[x y dir]]
	(cond
  		(= dir "E") [(inc x) y "E"]
  		(= dir "N") [x (inc y) "N"]
  		(= dir "W") [(dec x) y "W"]
  		(= dir "S") [x (dec y) "S"]
	)
)

(defn take-move [[x y dir nav_literal]]

	(cond
		(= nav_literal "L") (turn-left [x y dir])
		(= nav_literal "R") (turn-right [x y dir])
		(= nav_literal "M") (move [x y dir])
	)
)

(defn start-navigate [[x y dir] navigation-array]
	(if(= (empty? navigation-array) true)
		[x y dir]
		(start-navigate (take-move [x y dir (last navigation-array)]) (pop navigation-array))
	)
)

(defn navigate [[x y dir] navigation-string]
	(if(= (re-matches #"[LRM]*" navigation-string) nil)
		false
		(start-navigate [x y dir] (vec (reverse (clojure.string/split navigation-string #""))))	
	)
)






