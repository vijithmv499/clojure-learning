(ns mars-rover.core-test
  (:require [clojure.test :refer :all]
  			[mars-rover.core :refer :all]
  )
)

(deftest test-turn-left []
  
	(testing "returns West when current direction is North"
    	(is (= "W" ((turn-left [4 4 "N"]) 2)))
	)

	(testing "returns East when current direction is South"
    	; (is (= "E" (turn-left "S")))
    	(is (= "E" ((turn-left [2 4 "S"]) 2)))
	)
)

(deftest test-turn-right []
  
    (testing "returns South when current direction is East"
    	(is (= "S" ((turn-right [8 7 "E"]) 2)))
	)

	(testing "returns East when current direction is North"
    	(is (= "E" ((turn-right [5 9 "N"]) 2)))
	)
)

(deftest test-move []
 
    (testing "increment x by 1 if the current direction is East"
    	(is (= [5 6 "E"] (move [4 6 "E"])))
	)

	(testing "increment y by 1 if the current direction is North"
    	(is (= [4 7 "N"] (move [4 6 "N"])))
	)

	(testing "decrement x by 1 if the current direction is West"
    	(is (= [3 6 "W"] (move [4 6 "W"])))
	)

	(testing "decrement y by 1 if the current direction is South"
    	(is (= [4 5 "S"] (move [4 6 "S"])))
	)

	(testing "direction remains the same after move"
    	(is (= "N" ((move [4 6 "N"]) 2)))
	)	
)

(deftest test-take-move []

	(testing "return the new location by updating the x co-ordinate when navigation string is 'M' and direction is E"

		(is (= [4 5 "E"] (take-move [3 5 "E" "M"]))) 

	)
)

(deftest test-start-navigate []
	
	(testing "return the given co-ordinates and direction when the navigation array is empty"
		(is (= [5 6 "S"] (start-navigate [5 6 "S"] [])))
	)

	(testing "return the final co-ordinates and direction when non-empty navigation array is given"
		(is (= [6 8 "N"] (start-navigate [4 8 "E"] ["L","M","M"])) )
	)
)

(deftest test-navigate []

	(testing "return the final co-ordinates and direction when non-empty navigation string is given"
		(is (= [26 12 "E"] (navigate [20 10 "E"] "LMMRMMMMLRRLMM")))	
	)

	(testing "returns false when an invalid navigation string is passed"
		(is (= false (navigate [26 75 "W"] "LMMRGMMMMSRTLRRLMM")))	
	)
)

 