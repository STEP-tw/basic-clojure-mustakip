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