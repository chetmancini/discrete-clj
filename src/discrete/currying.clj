(ns discrete.currying)


(defn multiply [x y]
  (* x y))

(defn times-two [x]
  (* 2 x))

(defn make-multiplier [x]
  (fn [y] (multiply x y)))