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
      '() (reverse' [])))

  (testing "every?"
    (is (every?' even? [2 4 6]))
    (is (not (every?' even? #{1 2 3}))))

  (testing "some?"
    (is (some?' even? [3 2 5]))
    (is (not (some?' even? #{1 3}))))

  (testing "ascending?"
    (is (ascending? [1 2 3]))
    (is (not (ascending? [3 4 1 2]))))

  (testing "transpose"
    (is (= [[1 1] [2 2]] (transpose [[1 2] [1 2]])))
    (is (= [[1 1 1] [2 2 2] [3 3 3]] (transpose [[1 2 3] [1 2 3] [1 2 3]]))))

  (testing "difference"
    (is (= '(2 4) (difference [1 3 5 6] [1 2 3 4 5 6]))))

  (testing "union"
    (is (= '(1 2 3 4 5 6) (union [1 2 3] [4 5 6 3]))))

  (testing "palindrome?"
    (is (true? (palindrome? [1 2 3 2 1])))
    (is (false? (palindrome? [1 2 3 4 5])))
    (is (true? (palindrome? []))))

  (testing "index-of"
    (is (= 2 (index-of [7 6 5 4 3 8] 5)))
    (is (= -1 (index-of [1 2 3 4 5] 6))))

  (testing "sqr-of-the-first"
    (is (= '(16 16 16) (sqr-of-the-first [4 5 6]))))

  (testing "double-up"
    (is (= '(1 1 2 2 3 3) (double-up [1 2 3]))))

  (testing "cross-product"
    (is (= [[1 4] [1 3] [1 5] [2 4] [2 3] [2 5] [3 4]] (cross-product [1 2 3] [4 3 5]))))

  (testing "reduce"
    (is (= 10 (reduce' + [1 2 3 4])))
    (is (= 20 (reduce' + 10 [1 2 3 4]))))

  (testing "points-around-origin"
    (is (= '([-1 -1] [-1 0] [-1 1] [0 -1] [0 1] [1 -1] [1 0] [1 1]) (points-around-origin))))

  (testing "third-or-fifth"
    (is (= '(1 4 8) (third-or-fifth [1 2 3 4 5 8]))))

  (testing "russian-dolls"
    (is (= [[[1]] [[2]] [[3]]] (russian-dolls [1 2 3] 3)))))

