(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 4 (informative-divide 8 2))))
  (testing "zero denominator"
    (is (= :infinite (informative-divide 4 0)))))

(deftest harishchandra-test
  (testing "truthy values"
    (are [x y] (= x y)
               4 (harishchandra 4)
               true (harishchandra true))
    (testing "falsy values")
    (are [x y] (= x y)
               nil (harishchandra nil)
               nil (harishchandra false))))

(deftest yudishtira-test
  (testing "truthy values"
    (are [x y] (= x y)
               4 (yudishtira 4)
               true (yudishtira true)))
  (testing "falsy values"
    (are [x y] (= x y)
               :ashwathama (yudishtira nil)
               :ashwathama (yudishtira false))))

(deftest duplicate-first-test
  (testing "normal coll"
    (is (= [2 2 3 4] (duplicate-first [2 3 4]))))
  (testing "empty coll"
    (is (= nil (duplicate-first [])))))

(deftest five-point-someone-test
  (testing "return :chetan-bhagat if second arg is 5"
    (is (= :chetan-bhagat (five-point-someone 4 5))))
  (testing "return :satan-bhagat if first arg is 5"
    (is (= :satan-bhagat (five-point-someone 5 4))))
  (testing "return :greece if 1st arg > 2nd arg"
    (is (= :greece (five-point-someone 7 4)))))

(deftest repeat-and-truncate-test
  (testing "return repeated coll if rep? true and truncate? false"
    (is (= '(1 2 3 1 2) (take 5 (repeat-and-truncate [1 2 3] true false 0)))))
  (testing "return flattened truncated coll when both rep? and truncate? are specified true"
    (is (= '(1 2 3 1 2) (repeat-and-truncate [1 2 3] true true 5)))
    (is (= '() (repeat-and-truncate [1 2 3] true true 0)))))

(deftest zero-separated-palindrome-test
  (testing "normal list"
    (is (= '(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3]))))
  (testing "empty list"
    (is (= '(0) (zero-separated-palindrome []))))
  (testing "any element is not a number"
    (is (= [1 2 3 :a] (zero-separated-palindrome [1 2 3 :a])))))

(deftest zero-aliases-test
  (testing "zero like values"
    (are [x y] (= x y)
               :zero (zero-aliases 0)
               :empty (zero-aliases [])
               :empty (zero-aliases '())
               :empty-map (zero-aliases {})
               :empty-set (zero-aliases #{})))
  (testing "non zero values"
    (are [x y] (= x y)
               :not-zero (zero-aliases 4)
               :not-zero (zero-aliases "foo"))))

(deftest conditions-apply-test
  (testing "should return :wonder-woman if coll has single occurrence of 1 and 3 in that order"
    (is (= :wonder-woman (conditions-apply [1 2 3]))))
  (testing "should return :durga if coll has a single occurrence of :a :b and :c in that order"
    (is (= :durga (conditions-apply [:a :d :b :c]))))
  (testing "should return :cleopatra if coll has a single occurrence of [2 3] and [4 5] in that order"
    (is (= :cleopatra (conditions-apply [[2 3] [4 6] [5 6] [4 5]]))))
  (testing "should return :tuntun if none of the conditions are statisfied"
    (is (= :tuntun (conditions-apply [2 3 :a [2 3] :text])))))

(deftest order-in-words-test
  (testing "x greater than y and y greater than z"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "x greater than y and z greater than y"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "z greater than x"
    (is (= [:z-greater-than-x] (order-in-words 2 3 4)))))