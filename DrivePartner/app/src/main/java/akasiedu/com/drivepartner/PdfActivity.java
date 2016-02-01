package akasiedu.com.drivepartner;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by kwame on 4/28/15.
 */
public class PdfActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        WebView mWebView=new WebView(PdfActivity.this);
        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.getSettings().setPluginsEnabled(true);
        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mWebView.loadUrl("http://www.ct.gov/dmv/lib/dmv/20/29/r12eng.pdf");
        setContentView(mWebView);
    }
}
