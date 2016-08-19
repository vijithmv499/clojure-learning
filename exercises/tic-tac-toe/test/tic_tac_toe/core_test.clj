(ns tic-tac-toe.core-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.core :refer :all]))

(deftest horizontal-match-test []
	(testing "should return the matching element when a horizontal match is found"
    	(is (= 3 (horizontal-match [[3 3 3] [2 3 4] [4 5 6]])))
  	)

)

(deftest vertical-match-test []
	(testing "should return the matching element when a vertical match is found"
		(is (= 2 (vertical-match [[1 2 3] [3 2 5] [9 2 4]] ) ))
	)
)

(deftest diagonal-match-test []
	(testing "should return the matching element when a diagonal match is found"
		(is (= 4 (diagonal-match [[1 2 4] [3 4 5] [4 2 4]] ) ))
	)
)

(deftest game-winner-test []
	(testing "should return winner element when a match is found"
		(is (= 4 (game-winner [[1 2 4] [3 4 5] [4 2 4]] ) ))
	)

	(testing "should return nil when no match is found"
		(is (= nil (game-winner [[1 2 5] [3 4 5] [4 2 4]] ) ))
	)
)