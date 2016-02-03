package babushkatext;

import android.graphics.Color;
import android.graphics.Typeface;

public class Piece
{
    public  int DEFAULT_ABSOLUTE_TEXT_SIZE;
    private static float DEFAULT_RELATIVE_TEXT_SIZE = 1;
    public  int textSize;
    public final int backgroundColor;
    public final float textSizeRelative;
    public final int style;
    public final boolean underline;
    public final boolean superscript;
    public final boolean strike;
    public final boolean subscript;
    public String text;
    public int textColor;

    public Piece(Builder builder)
    {
        this.text = builder.text;
        this.textSize = builder.textSize;
        this.textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
        this.textSizeRelative = builder.textSizeRelative;
        this.style = builder.style;
        this.underline = builder.underline;
        this.superscript = builder.superscript;
        this.subscript = builder.subscript;
        this.strike = builder.strike;
    }

    public void setText(String text)
    {
        this.text = text;
    }


    public void setTextColor(int textColor)
    {
        this.textColor = textColor;
    }

    /**
     * Builder of Pieces
     */
    public static class Builder
    {

        // required
        public final String text;


        // optional
        public int textSize ;
        public int textColor = Color.BLACK;
        public int backgroundColor = -1;
        public float textSizeRelative = DEFAULT_RELATIVE_TEXT_SIZE;
        public int style = Typeface.NORMAL;
        public boolean underline = false;
        public boolean strike = false;
        public boolean superscript = false;
        public boolean subscript = false;

        /**
         * Creates a new Builder for this Piece.
         *
         * @param text the text of this Piece
         */
        public Builder(String text)
        {
            this.text = text;
        }

        /**
         * Sets the absolute text size.
         *
         * @param textSize text size in pixels
         * @return a Builder
         */
        public Builder textSize(int textSize)
        {
            this.textSize = textSize;
            return this;
        }

        /**
         * Sets the text color.
         *
         * @param textColor the color
         * @return a Builder
         */
        public Builder textColor(int textColor)
        {
            this.textColor = textColor;
            return this;
        }

        /**
         * Sets the background color.
         *
         * @param backgroundColor the color
         * @return a Builder
         */
        public Builder backgroundColor(int backgroundColor)
        {
            this.backgroundColor = backgroundColor;
            return this;
        }

        /**
         * Sets the relative text size.
         *
         * @param textSizeRelative relative text size
         * @return a Builder
         */
        public Builder textSizeRelative(float textSizeRelative)
        {
            this.textSizeRelative = textSizeRelative;
            return this;
        }

        /**
         * Sets a style to this Piece.
         *
         * @param style see {@link Typeface}
         * @return a Builder
         */
        public Builder style(int style)
        {
            this.style = style;
            return this;
        }

        /**
         * Underlines this Piece.
         *
         * @return a Builder
         */
        public Builder underline()
        {
            this.underline = true;
            return this;
        }

        /**
         * Strikes this Piece.
         *
         * @return a Builder
         */
        public Builder strike()
        {
            this.strike = true;
            return this;
        }

        /**
         * Sets this Piece as a superscript.
         *
         * @return a Builder
         */
        public Builder superscript()
        {
            this.superscript = true;
            return this;
        }

        /**
         * Sets this Piece as a subscript.
         *
         * @return a Builder
         */
        public Builder subscript()
        {
            this.subscript = true;
            return this;
        }

        public Piece build()
        {
            return new Piece(this);
        }
    }
}