(ns discrete.utils-test
  (:require [clojure.test :refer :all]
            [discrete.utils :refer :all]))

(deftest listify-test
  (testing "turns all items into their own list"
    (is (= [[1] [2] [3]] (listify [1 2 3])))))

(deftest add-to-all-test
  (testing "adds item to all items in list"
    (is (= [[5] [5 4] [5 1 2]] (add-to-all 5 [[] [4] [1 2]])))))

(deftest make-no-repeats-test
  (testing "removes duplicates"
    (is (= [1 2 3] (make-no-repeats [1 1 2 2 2 3])))))