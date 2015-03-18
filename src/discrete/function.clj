(ns discrete.function)

(defn list-to-fn [items]
  (fn [n] (nth items n)))