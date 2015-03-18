(ns discrete.relation-test
  (:require [clojure.test :refer :all]
            [discrete.relation :refer :all]))

(deftest add-image-test
  (testing "add image"
    (is (= [[5] [5 4] [5 2 3]] (add-image 5 [[] [4] [2 3]])))))