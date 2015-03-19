(ns discrete.peano)

(def zero [:zero])
(def one-plus #(cons :one-plus %))
(def one-minus rest)

(defn succ
  "Return the successor to this peano number"
  [peano]
  (one-plus peano))

(defn pred
  "Return the predecessor to this peano number"
  [peano]
  (one-minus peano))

(defn as-peano-number
  "Convert an integer to a peano number"
  [integer]
  (if (= 0 integer)
    zero
    (one-plus (as-peano-number (- integer 1)))))

(defn as-integer
  "Convert a peano number to an integer"
  [peano]
  (if (= zero peano) 
    0
    (+ 1 (as-integer (one-minus peano)))))

(defn <=? 
  "Less than or equal as defined for peano numbers"
  [p1 p2]
  (cond 
    (= zero p1) true
    (= zero p2) false
    :else (<=? (one-minus p1) (one-minus p2))))

(defn <?
  "Less than for peano numbers"
  [p1 p2]
  (cond
    (= zero p1 p2) false
    (= zero p1) true
    (= zero p2) false
    :else (<? (one-minus p1) (one-minus p2))))

(defn =? 
  "Equals for peano numbers"
  [p1 p2]
  (cond
    (= zero p1 p2) true
    (or (= zero p1) (= zero p2)) false
    :else (=? (one-minus p1) (one-minus p2))))

(defn minus 
  "Subtraction for peano numbers"
  [p1 p2]
  (if (= zero p2)
    p1
    (minus (one-minus p1) (one-minus p2))))

(defn plus
  "Addition on peano numbers"
  [p1 p2]
  (if (= zero p2)
    p1
    (plus (one-plus p1) (one-minus p2))))

(defn multiply 
  "Multiplication on peano numbers"
  [p1 p2]
  (if (or (= zero p1) (= zero p2))
    zero
    (plus p1 (multiply p1 (one-minus p2)))))

(defn divide
  "Division on peano numbers"
  [p1 p2]
  (let [divide-helper (fn [a b current]
                        (cond 
                          (<? a b) current
                          (=? a b) (one-plus current)
                          :else (recur (minus a b) b (one-plus current))))]
    (divide-helper p1 p2 zero)))

(defn is-even?
  "Even checking on peano numbers"
  [peano]
  (cond 
    (= zero peano) true
    (= zero (one-minus peano)) false
    :else (is-even? (one-minus (one-minus peano)))))

(defn gcd [p1 p2]
  ())



