(ns discrete.utils-test
  (:require [clojure.test :refer :all]
            [discrete.utils :refer :all]))

(deftest listify-test
  (testing "turns all items into their own list"
    (is (= [[1] [2] [3]] (listify [1 2 3])))))

(deftest add-to-all-test
  (testing "adds item to all items in list"
    (is (= [[5] [5 4] [5 1 2]] (add-to-all 5 [[] [4] [1 2]])))))

