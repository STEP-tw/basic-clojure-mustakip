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
      '(2 4) (filter' even? [1 2 3 4 5]))))

