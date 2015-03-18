(ns discrete.utils)

(defn listify [values]
  (map #(list %) values))

(defn add-to-all [item values]
  (map #(cons item %) values))

(defn in? [seq elm]  
  (some #(= elm %) seq))