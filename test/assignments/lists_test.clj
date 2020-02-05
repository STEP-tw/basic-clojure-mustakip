(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "mapping single coll)"
      (are [x y]
        (= x y)
        [1 2 3] (map' identity [1 2 3])
        [2 3 4] (map' inc [1 2 3]))))

  (testing "filter"
    (are [x y]
      (= x y)
      '(1 3 5) (filter' odd? [1 2 3 4 5])
      '(2 4) (filter' even? [1 2 3 4 5])))

  (testing "count"
    (are [x y]
      (= x y)
      4 (count' [1 2 3 4])
      3 (count' '(1 2 3))
      3 (count' #{1 2 3})
      0 (count' [])))

  (testing "reverse"
    (are [x y]
      (= x y)
      '(3 2 1) (reverse' [1 2 3])
      '([:b 2] [:a 1]) (reverse' {:a 1 :b 2})
      '() (reverse' []))))

