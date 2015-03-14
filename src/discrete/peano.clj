(ns discrete.peano)

(def zero [:zero])
(def one-plus #(cons :one-plus %))
(def one-minus rest)

(defn succ [peano]
  (one-plus peano))

(defn pred [peano]
  (one-minus peano))

(defn as-peano-number [integer]
  (if (= 0 integer)
    zero
    (one-plus (as-peano-number (- integer 1)))))

(defn as-integer [peano]
  (if (= zero peano) 
    0
    (+ 1 (as-integer (one-minus peano)))))

(defn <=? [p1 p2]
  (cond 
    (= zero p1) true
    (= zero p2) false
    :else (<=? (one-minus p1) (one-minus p2))))

(defn minus [p1 p2]
  (if (= zero p2)
    p1
    (minus (one-minus p1) (one-minus p2))))

(defn plus [p1 p2]
  (if (= zero p2)
    p1
    (plus (one-plus p1) (one-minus p2))))

(defn =? [p1 p2]
  (if (= zero p1 p2)
    true
    (=? (one-minus p1) (one-minus p2))))

(defn multiply [p1 p2]
  ())

(defn divide [p1 p2]
  ())

(defn is-even? [peano]
  (cond 
    (= zero peano) true
    (= zero (one-minus peano)) false
    :else (is-even? (one-minus (one-minus peano)))))

(defn gcd [p1 p2]
  ())



