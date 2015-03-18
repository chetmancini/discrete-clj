(ns discrete.function-test
  (:require [clojure.test :refer :all]
            [discrete.function :refer :all]))

(deftest list-to-fn-test
  (testing "convert a list to a function"
    (is (= "b" ((list-to-fn ["a" "b" "c" "d"]) 1)))))

(deftest compose-test
  (testing "compose two functions"
    (let [f (fn [x] (* x 2))
          g (fn [x] (+ x 3))
          composed (compose f g)]
      (is (= 7 (composed 2))))))