(ns discrete.conditional)

; fun contains(x, []) = false
;   | contains(x, y::rest) = 
;     if x = y then true 
;     else contains(x, rest);

; (* "plot" datatypes---from earlier sections *)
; datatype tree = Oak | Elm | Maple | Spruce | Fir | Pine | Willow;
; datatype vegetable = Carrot | Zucchini | Tomato | Cucumber | Lettuce;
; datatype grain = Wheat | Oat | Barley | Maize;
; datatype plot = Field of grain | Garden of vegetable list | Grove of tree | Vacant;


; fun replaceVegetable(orig, subst, Garden([])) = Garden([])
;    | replaceVegetable(orig, subst, Garden(first::rest)) =
;        let val Garden(newRest) = 
;                replaceVegetable(orig, subst, Garden(rest));
;        in Garden((if first = orig then subst else first) 
;                  :: newRest)
;        end
;    | replaceVegetable(orig, subst, x) = x;


; (* language processor datatypes---from earlier sections *)

; datatype noun = Noun of string;
; datatype article = Art of string;
; datatype adjective = Adj of string;
; datatype preposition = Prep of string;
; datatype transitiveVerb = TV of string;
; datatype intransitiveVerb = IV of string;
; datatype linkingVerb = LV of string;
; datatype adverb = Adv of string;
; datatype nounPhrase = NounPhrase of (article * adjective option * noun);
; datatype verbPhrase = TVP of (transitiveVerb * nounPhrase)
;                     | IVP of (intransitiveVerb)
;                     | LVP of (linkingVerb * adjective);
; datatype predicate = Predicate of (adverb option * verbPhrase);
; datatype prepPhrase = PrepPhrase of (preposition * nounPhrase);
; datatype sentence = Sentence of (nounPhrase * predicate * prepPhrase option);


; (* The following contains more code than appears in the text at this section. *)

; exception WordNotFound of string

; val adjectives = ["big", "bright", "fase", "beautiful", "smart",
;                   "red", "smelly"];

; val transitiveVerbs = ["chased", "saw", "greeted", "bit", "loved"];

; val intransitiveVerbs = ["ran", "slept", "sang"];

; val linkingVerbs = ["was", "felt", "seemed"];

; val nouns = ["man", "woman", "dog", "unicorn", "ball", "field",
;              "flea", "tree", "sky"];

; val adverbs = ["quickly", "slowly", "dreamily", "happily"];


; fun parseArticle("the"::rest) = (Art("the"), rest)
;   | parseArticle("a"::rest) = (Art("a"), rest);

; fun parseAdjective(next::rest) =
;     if contains(next, adjectives) 
;     then (SOME(Adj(next)), rest)
;     else (NONE, next::rest);

; fun parseNoun(next::rest) =
;     if contains(next, nouns) then (Noun(next), rest)
;                                   else raise WordNotFound(next);

; fun parsePreposition(next::rest) = (Prep(next), rest);

; fun parseAdverb(next:: rest) = 
;     if contains(next, adverbs) then (SOME(Adv(next)), rest)
;                                      else (NONE, next::rest)

; fun parseNounPhrase(wordList) =
;     let val (art, rest1) = parseArticle(wordList);
;         val (adj, rest2) = parseAdjective(rest1);
;         val (nn, rest3) = parseNoun(rest2);
;     in
;         (NounPhrase(art, adj, nn), rest3)
;     end;

; fun parseTransVerb(vb, wordList) = 
;     let val (dirObj, rest) = parseNounPhrase(wordList);
;     in (TVP(vb, dirObj), rest)
;     end;

; fun parseLinkingVerb(vb, wordList) =
;     let val (adj, rest) = parseAdjective(wordList);
;     in (LVP(vb, valOf(adj)), rest)
;     end;

; fun parseVerbPhrase(next::rest) =
;     if contains(next, transitiveVerbs) 
;     then parseTransVerb(TV(next), rest)
;     else if contains(next, intransitiveVerbs) 
;     then (IVP(IV(next)), rest)
;     else if contains(next, linkingVerbs) 
;     then parseLinkingVerb(LV(next), rest)
;     else raise WordNotFound(next);

