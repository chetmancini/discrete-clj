(ns discrete.boolean)

(defn is-even? [n]
  (cond (= 0 n) true
        (= 1 n) false
        :else (recur (- n 2))))

(defn is-even-2? [n]
  (if (= n 0)
    true
    (not (is-even-2? (- n 1)))))

(defn is-even-mod? [n]
  (= 0 (mod n 2)))

; fun isEven(0) = true
;   | isEven(n) = not(isEven(n-1));

; fun isEven(n) = n mod 2 = 0;)