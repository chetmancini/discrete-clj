(ns discrete.utils)

(defn listify
  "Convert a list of elements to a list of list of elements [1 2] -> [[1] [2]]"
  [values]
  (map #(list %) values))

(defn add-to-all
  "Add an item to all the elements in a sequence"
  [item values]
  (map #(cons item %) values))

(defn in?
  "Returns if a sequence contains an element"
  [seq elm]
  (some #(= elm %) seq))