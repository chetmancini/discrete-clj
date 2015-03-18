(ns discrete.function)

(defn list-to-fn [items]
  (fn [n] (nth items n)))

(defn compose 
  "Compose two functions f and g to construct a function that applies f and g to a given input."
  [f g]
  (fn [x] (g (f x))))