(ns discrete.quantification)

(defn all-have-divisor? [input-list yy]
  (if (empty? input-list)
    true
    (let [has-divisor? (fn [second-list]
                        (if (empty? second-list)
                          false
                          (if (= 0 (mod (first input-list) (first second-list)))
                            true
                            (recur (rest second-list)))))]
      (and (has-divisor? yy) (all-have-divisor? (rest input-list) yy)))))

