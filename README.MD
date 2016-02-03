BabushkaText
============

BabushkaText is a custom `TextView` which lets you customize the styling of parts of your text via
`Spannables`, but without the hassle of having to deal directly with Spannable themselves.

 * Create complex style structures for your text without having to add multiple `TextViews` to your
 view hierarchy.
 * Eliminate `setSpan(Object what, int start, int end, int flags)` calls by using more convenient
 methods such as `.style(Typeface.BOLD)`, `.superscript()` and others.

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.Aarthas:BabushkaText:2.2'
	}
	
What can I do with BabushkaText?
--------
Examples of different styles. Each one is a **single** TextView.

![Logo](images/example.png)

Example
--------
Generate the following style:

![NewY York](images/newyork.png)

With the code below:

```java
        BabushkaText babushka = (BabushkaText)findViewById(R.id.babushka_text);

        // Add the first piece "Central Park"
        babushka.addPiece(new BabushkaText.Piece.Builder("Central Park, NY\n")
                .textColor(Color.parseColor("#414141"))
                .build());

        // Add the second piece "1.2 mi"
        babushka.addPiece(new BabushkaText.Piece.Builder("1.2 mi ")
                .textColor(Color.parseColor("#0081E2"))
                .textSizeRelative(0.9f)
                .build());

        // Add the third piece "from here"
        babushka.addPiece(new BabushkaText.Piece.Builder("from here")
                .textColor(Color.parseColor("#969696"))
                .textSizeRelative(0.9f)
                .build());

        // Display the final, styled text
        babushka.display();
```

What kind of styles can I add?
--------
Right now you can customize the style of your text by using the following methods, which internally
get converted to the corresponding `Spannables`

| Babushka Method        | Internal Span           |
| ------------- |:-------------:|
| textSize      | AbsoluteSizeSpan |
| textColor      | ForegroundColorSpan      |
| textSizeRelative | RelativeSizeSpan      |
| backgroundColor | BackgroundColorSpan      |
| style | StyleSpan      |
| underline | UnderlineSpan      |
| strike | StrikethroughSpan      |
| superscript | SuperscriptSpan      |
| subscript | SubscriptSpan      |

What else can I do?
--------
Once you've created and displayed your BabushkaText, you can modify the text contents of each
`Piece` individually. For example, if we want to change the `1.2 mi` from the above example into
`1.9 km`, we could do the following:

```java
// grab the Piece at position 1
Piece piece = babushka.getPiece(1);

// modify it's text
piece.setText("1.9 km ");

// you must always call display after you alter a Piece's text
babushka.display();
```

Download
--------
BabushkaText is a single Java file, so you can simply download it and reference it in your project.

Download `BabushkaText.java` here:  **[BabushkaText](https://github.com/quiqueqs/BabushkaText/blob/master/babushkatext/src/main/java/babushkatext/BabushkaText.java)**

Or if you prefer, you can simply download **[the JAR](https://github.com/quiqueqs/BabushkaText/tree/master/downloads/babushka-0.1.jar)**

Contact Me
--------
If you find any **bugs** or have a **problem** while using this library, please [open an issue](https://github.com/quiqueqs/BabushkaText/issues/new) in this repo (or a pull request :)).

License
-------

    Copyright 2014 Henrique Boregio

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
