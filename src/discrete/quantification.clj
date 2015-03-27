(ns discrete.quantification)

(defn all-have-divisor? [input-list divisor]
  (if (empty? input-list)
    true
    (let [has-divisor? (fn [input]
                        (if (empty? input)
                          false
                          (if (= 0 (mod (first input-list) (first input)))
                            true
                            (has-divisor? (rest input)))))]
      (and (has-divisor? divisor) (all-have-divisor? (rest input-list) divisor)))))

