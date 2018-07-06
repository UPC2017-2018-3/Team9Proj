package commun_part;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 閲嶅啓涓�涓笉鍙互婊戝姩鐨刲istview
 *
 * @author yangjiabei
 *         Created by Admin on 2016/5/10.
 */
public class NoScrollListView extends ListView {
    public NoScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mExpandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, mExpandSpec);
    }
}
