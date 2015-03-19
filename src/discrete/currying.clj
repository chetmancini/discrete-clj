(ns discrete.currying)

(defn multiply [x y]
  (* x y))

(defn times-two [x]
  (* 2 x))

(defn make-multiplier 
  "Demonstrate currying by taking a value and returning a function which multiplies by that value"
  [x]
  (fn [y] (multiply x y)))