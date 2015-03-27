(ns discrete.boolean-test
  (:require [clojure.test :refer :all]
            [discrete.boolean :refer :all]))

(deftest is-even-test
  (testing "is even"
    (is (is-even? 0))
    (is (not (is-even? 1)))
    (is (is-even? 4))))

(deftest is-even-2-test
  (testing "is even 2"
    (is (is-even-2? 0))
    (is (is-even-2? 4))
    (is (not (is-even-2? 1)))))

(deftest is-even-mod-test
  (testing "is even 2"
    (is (is-even-mod? 0))
    (is (is-even-mod? 4))
    (is (not (is-even-mod? 1)))))