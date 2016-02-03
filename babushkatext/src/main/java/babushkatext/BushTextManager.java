package babushkatext;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/12/16.
 */
public class BushTextManager
{
    private final TextView textView;
    private final int DEFAULT_ABSOLUTE_TEXT_SIZE;

    public BushTextManager(TextView textView)
    {
        this.mPieces = new ArrayList<>();
        this.textView = textView;
        DEFAULT_ABSOLUTE_TEXT_SIZE = (int) textView.getTextSize();
    }

    private List<Piece> mPieces;

    public void addPiece(Piece aPiece)
    {
        mPieces.add(aPiece);
    }
    public Piece getPiece(int location)
    {
        if (location >= 0 && location < mPieces.size())
        {
            return mPieces.get(location);
        }

        return null;
    }


    public SpannableString display()
    {

        // generate the final string based on the pieces
        StringBuilder builder = new StringBuilder();
        for ( Piece aPiece : mPieces )
        {
            builder.append(aPiece.text);
        }

        // apply spans
        int cursor = 0;
        SpannableString finalString = new SpannableString(builder.toString());
        for ( Piece aPiece : mPieces )
        {
            applySpannablesTo(aPiece, finalString, cursor, cursor + aPiece.text.length());
            cursor += aPiece.text.length();
        }

        // set the styled text
        textView.setText(finalString);
        return finalString;
    }


    private void applySpannablesTo(Piece aPiece, SpannableString finalString, int start, int end)
    {

        if (aPiece.subscript)
        {
            finalString.setSpan(new SubscriptSpan(), start, end, Spannable
                    .SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        if (aPiece.superscript)
        {
            finalString.setSpan(new SuperscriptSpan(), start, end, Spannable
                    .SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        if (aPiece.strike)
        {
            finalString.setSpan(new StrikethroughSpan(), start, end, Spannable
                    .SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        if (aPiece.underline)
        {
            finalString.setSpan(new UnderlineSpan(), start, end, Spannable
                    .SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // style
        finalString.setSpan(new StyleSpan(aPiece.style), start, end, Spannable
                .SPAN_EXCLUSIVE_EXCLUSIVE);

        // absolute text size
        if (aPiece.textSize==0)
        {
            aPiece.textSize = DEFAULT_ABSOLUTE_TEXT_SIZE;
        }
        finalString.setSpan(new AbsoluteSizeSpan(aPiece.textSize), start, end, Spannable
                .SPAN_EXCLUSIVE_EXCLUSIVE);

        // relative text size
        finalString.setSpan(new RelativeSizeSpan(aPiece.textSizeRelative), start, end, Spannable
                .SPAN_EXCLUSIVE_EXCLUSIVE);

        // text color
        finalString.setSpan(new ForegroundColorSpan(aPiece.textColor), start, end, Spannable
                .SPAN_EXCLUSIVE_EXCLUSIVE);

        // background color
        if (aPiece.backgroundColor != -1)
        {
            finalString.setSpan(new BackgroundColorSpan(aPiece.backgroundColor), start, end,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

}
