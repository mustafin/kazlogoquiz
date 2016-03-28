package flat56.kazlogoquiz.activities.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import flat56.kazlogoquiz.Dummy;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.LogosActivity;
import flat56.kazlogoquiz.models.Logo;

public class DescFragment extends Fragment {
    public static final String LOGO_EXTRA = "LOGO_EXTRA";
    private Logo logo;
    private int levelPos;
    private int logoPos;
    private Context context;

    private OnFragmentInteractionListener mListener;

    public DescFragment() {
    }

    public static DescFragment newInstance(int levelPos, int logoPos) {
        DescFragment fragment = new DescFragment();

        Bundle args = new Bundle();

        args.putInt(LogosActivity.LEVEL_EXTRA, levelPos);
        args.putInt(LOGO_EXTRA, logoPos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            levelPos = getArguments().getInt(LogosActivity.LEVEL_EXTRA);
            logoPos = getArguments().getInt(LOGO_EXTRA);
            logo = Dummy.levelList.get(levelPos).getLogos().get(logoPos);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_desc, container, false);

        TextView title = (TextView) view.findViewById(R.id.title);
        TextView description = (TextView) view.findViewById(R.id.description);
        Button back = (Button) view.findViewById(R.id.back);

        title.setText(logo.getCorrect());
        description.setText(logo.getDescription());

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentAction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
