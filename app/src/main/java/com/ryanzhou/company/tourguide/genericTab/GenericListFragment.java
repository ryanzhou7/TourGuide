package com.ryanzhou.company.tourguide.genericTab;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ryanzhou.company.tourguide.R;

public class GenericListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    public static final String ARRAY_RES_ID_KEY = "arrayResIdKey";
    public static final int ERROR_CODE_ARRAY_RES_ID = 0;
    private String[] items;

    public GenericListFragment() {
    }

    public static GenericListFragment newInstance(int arrayResourceId) {
        Bundle bundle = new Bundle();
        bundle.putInt(ARRAY_RES_ID_KEY, arrayResourceId);
        GenericListFragment genericListFragment = new GenericListFragment();
        genericListFragment.setArguments(bundle);
        return genericListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_generic_list, container, false);
        Bundle bundle = getArguments();
        int resourceId = bundle.getInt(ARRAY_RES_ID_KEY, ERROR_CODE_ARRAY_RES_ID);
        if (isValidArrayResId(resourceId))
            items = getActivity().getResources().getStringArray(resourceId);
        else
            items = new String[]{"No Data available"};
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_activated_1, items);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onClickItemWithname(items[position]);
            }
        });

        return view;
    }

    private Boolean isValidArrayResId(int resourceId) {
        if (resourceId == ERROR_CODE_ARRAY_RES_ID)
            return false;
        return true;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onClickItemWithname(String itemName);
    }
}
