package flat56.kazlogoquiz.activities.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.LogosActivity;
import flat56.kazlogoquiz.domain.DataParser;
import flat56.kazlogoquiz.domain.models.Level;
import flat56.kazlogoquiz.domain.models.Logo;

import static flat56.kazlogoquiz.utils.DataUtils.*;

public class DescFragment extends Fragment {
    public static final String LOGO_EXTRA = "LOGO_EXTRA";
    private Logo logo;
    private int levelId;
    private int logoId;
    private Context context;
    private List<Level> data;

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

        DataParser parser = DataParser.getInstance(getActivity().getBaseContext());
        data = parser.getCachedLevels();

        if (getArguments() != null) {
            levelId = getArguments().getInt(LogosActivity.LEVEL_EXTRA);
            logoId = getArguments().getInt(LOGO_EXTRA);
            logo = findLogo(data, levelId, logoId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(context == null)
            context = getActivity().getBaseContext();
        View view = inflater.inflate(R.layout.fragment_desc, container, false);

        TextView title = (TextView) view.findViewById(R.id.title);
        TextView description = (TextView) view.findViewById(R.id.description);
        LinearLayout points = (LinearLayout) view.findViewById(R.id.points);
        points.setClipChildren(false);
        for (int i = 0; i < logo.getPoints(); i++) {
            ImageView point = new ImageView(getActivity().getBaseContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 0, 0, 5);
            point.setLayoutParams(params);
            point.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_tenge_medium));
            points.addView(point);

        }

        title.setText(logo.getCorrect());
        description.setText(logo.getDescription());

        return view;
    }

    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentAction();
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
