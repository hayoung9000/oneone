package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by YookyungJung on 2017-11-21.
 */

public class BookList2 extends Fragment implements View.OnClickListener{
    private ArrayList<BookItem> data=null;

    @SuppressLint("MissingSuperCall")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.book_list,container, false);
        ListView listView=(ListView)rootView.findViewById(R.id.book_listview);


        data=new ArrayList<>();

        BookItem b[]=new BookItem[40];

        b[0]=new BookItem(R.drawable.mestart, "메리","안녕달","사계절");

        b[2]=new BookItem(R.drawable.astart, "아빠 무릎은 내 자리","나은경","킨더랜드");

        b[34]=new BookItem(R.drawable.jistart, "지난 여름","김지현","웅진주니어");

        b[6]=new BookItem(R.drawable.istart, "이렇게 멋진 날","리처드 잭슨","비룡소");

        b[4]=new BookItem(R.drawable.sumstart, "숨바꼭질","앤서니 브라운","웅진주니어");

        b[1]=new BookItem(R.drawable.wostart, "우리는 언제나 다시 만나","윤여림","스콜라");

        b[5]=new BookItem(R.drawable.ahstart, "엄마는 해녀입니다.","고희영","난다");

        b[7]=new BookItem(R.drawable.mulstart, "물의 공주","수전 베르데","크레용하우스");

        b[3]=new BookItem(R.drawable.alstart, "알사탕","백희나","책 읽는 곰");

        b[21]=new BookItem(R.drawable.fstart, "펭귄은 너무해","조리 존","미디어 창비");

        b[11]=new BookItem(R.drawable.sinstart, "신기한 씨앗 가게","미야니시 타츠야","미래i아이");

        b[9]=new BookItem(R.drawable.gastart, "한밤 중 개미요정","신선미","창비");

        b[10]=new BookItem(R.drawable.hangstart, "행복한 청소부","모니카 페트","풀빛");

        b[36]=new BookItem(R.drawable.jihstart, "나는 지하철입니다.","김효은","문학동네");

        b[12]=new BookItem(R.drawable.bmstart, "벗지말걸 그랬어","요시타케 신스케","스콜라");

        b[8]=new BookItem(R.drawable.abstart, "아빠는 회사에서 내 생각해?","김영진","길벗어린이");

        b[14]=new BookItem(R.drawable.halstart, "할머니 어디계세요?","에드먼드 림","다섯수레");

        b[16]=new BookItem(R.drawable.umstart, "엄마의 말","최숙희","책 읽는 곰");

        b[13]=new BookItem(R.drawable.pustart, "푸른 수염","아멜리 노통브","열린책들");

        b[17]=new BookItem(R.drawable.pigstart, "돼지 공주","조너선 에메트","킨더랜드");

        b[19]=new BookItem(R.drawable.estart, "이어도에서 온 선물","권요원","한우리 문학");

        b[20]=new BookItem(R.drawable.hastart, "알프스 소녀 하이디","요한나 슈피리","인디고(글담)");

        b[22]=new BookItem(R.drawable.bostart, "핑크공주와 친구가 된 보라공주","빅토리아 칸, 엘리자베스 칸","달리");

        b[32]=new BookItem(R.drawable.pigstart, "돼지책","앤서니 브라운","웅진 주니어");

        b[23]=new BookItem(R.drawable.baestart, "배고픈 애벌레","에릭 칼","제이와이 북스");

        b[24]=new BookItem(R.drawable.namestart, "난 내 이름이 참 좋아!","케빈 헹크스","비룡소");

        b[25]=new BookItem(R.drawable.ngstart, "누가 내 머리에 똥쌌어?","베르너 홀츠바르트","사계절");

        b[15]=new BookItem(R.drawable.julstart, "줄무늬가 생겼어요.","데이빗 섀논","비룡소");

        b[26]=new BookItem(R.drawable.gilstart, "길아저씨 손아저씨","권정생","국민서관");

        b[39]=new BookItem(R.drawable.okstart, "괜찮아","최숙희","웅진 주니어");

        b[27]=new BookItem(R.drawable.igestart, "이게 정말 나일까?","요시타케 신스케","주니어 김영사");

        b[28]=new BookItem(R.drawable.gustart, "구름빵","백희나","한솔수북");

        b[38]=new BookItem(R.drawable.saestart, "세 개의 황금열쇠","피터 시스","사계절 출판사");

        b[29]=new BookItem(R.drawable.monstart, "괴물들이 사는 나라","모리스 센닥","시공 주니어");

        b[31]=new BookItem(R.drawable.mastart, "마법의 설탕 두 조각","미하엘 엔데","소년한길");

        b[33]=new BookItem(R.drawable.beststart, "우리 선생님이 최고야!","케빈 헹크스","비룡소");

        b[18]=new BookItem(R.drawable.jongstart, "종이봉지 공주","로버트 먼치","비룡소");

        b[35]=new BookItem(R.drawable.gostart, "고릴라","앤서니 브라운","비룡소");

        b[37]=new BookItem(R.drawable.mustart, "무지개 물고기","마르쿠스 피스터","시공주니어");

        b[30]=new BookItem(R.drawable.dowstart, "도깨비를 빨아버린 우리 엄마.","사토 와키코","한림 출판사");
        // BookItem b1=new BookItem(R.drawable.profile, "제목","작가","출판사1");


        for(int i=0; i<40; i++) {
            data.add(b[i]);
        }

        BookAdapter adapter=new BookAdapter(this.getContext(), R.layout.book_item, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Intent intent=new Intent(getApplicationContext(), BookClicked.class);
                intent.putExtra("profile", Integer.toString(data.get(position).getProfile()));
                intent.putExtra("BookName", data.get(position).getBookName());
                intent.putExtra("writer", data.get(position).getWriter());
                intent.putExtra("publisher", data.get(position).getPublisher());

                startActivity(intent);*/
                if(data.get(position).getBookName()=="메리") {
                    Intent intent = new Intent(getActivity(), Book_meActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="아빠 무릎은 내 자리") {
                    Intent intent = new Intent(getActivity(), Book_aActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="지난 여름") {
                    Intent intent = new Intent(getActivity(), Book_jiActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="이렇게 멋진 날") {
                    Intent intent = new Intent(getActivity(), Book_iActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="숨바꼭질") {
                    Intent intent = new Intent(getActivity(), Book_sumActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="우리는 언제나 다시 만나") {
                    Intent intent = new Intent(getActivity(), Book_woActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="엄마는 해녀입니다") {
                    Intent intent = new Intent(getActivity(), Book_ahActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="물의 공주") {
                    Intent intent = new Intent(getActivity(), Book_mulActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="알사탕") {
                    Intent intent = new Intent(getActivity(), Book_alActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="펭귄은 너무해") {
                    Intent intent = new Intent(getActivity(), Book_fActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="신기한 씨앗 가게") {
                    Intent intent = new Intent(getActivity(), Book_sinActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="한밤 중 개미요정") {
                    Intent intent = new Intent(getActivity(), Book_gaActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="행복한 청소부") {
                    Intent intent = new Intent(getActivity(), Book_hangActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="나는 지하철입니다") {
                    Intent intent = new Intent(getActivity(), Book_jihActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="벗지말걸 그랬어") {
                    Intent intent = new Intent(getActivity(), Book_bmActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="아빠는 회사에서 내 생각해?") {
                    Intent intent = new Intent(getActivity(), Book_abActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="할머니 어디계세요?") {
                    Intent intent = new Intent(getActivity(), Book_halActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="엄마의 말") {
                    Intent intent = new Intent(getActivity(), Book_umActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="푸른 수염") {
                    Intent intent = new Intent(getActivity(), Book_puActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="돼지 공주") {
                    Intent intent = new Intent(getActivity(), Book_pigActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="이어도에서 온 선물") {
                    Intent intent = new Intent(getActivity(), Book_eActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="알프스 소녀 하이디") {
                    Intent intent = new Intent(getActivity(), Book_haActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="핑크공주와 친구가 된 보라공주") {
                    Intent intent = new Intent(getActivity(), Book_boActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="돼지책") {
                    Intent intent = new Intent(getActivity(), Book_dActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="배고픈 애벌레") {
                    Intent intent = new Intent(getActivity(), Book_baeActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="난 내 이름이 참 좋아!") {
                    Intent intent = new Intent(getActivity(), Book_nameActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="누가 내 머리에 똥쌌어?") {
                    Intent intent = new Intent(getActivity(), Book_ngActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="줄무늬가 생겼어요.") {
                    Intent intent = new Intent(getActivity(), Book_julActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="길아저씨 손아저씨") {
                    Intent intent = new Intent(getActivity(), Book_gilActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="괜찮아") {
                    Intent intent = new Intent(getActivity(), Book_okActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="이게 정말 나일까?") {
                    Intent intent = new Intent(getActivity(), Book_igeActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="구름빵") {
                    Intent intent = new Intent(getActivity(), Book_guActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="세 개의 황금열쇠") {
                    Intent intent = new Intent(getActivity(), Book_saeActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="괴물들이 사는 나라") {
                    Intent intent = new Intent(getActivity(), Book_monActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="마법의 설탕 두 조각") {
                    Intent intent = new Intent(getActivity(), Book_maActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="우리 선생님이 최고야!") {
                    Intent intent = new Intent(getActivity(), Book_bestActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="종이봉지 공주") {
                    Intent intent = new Intent(getActivity(), Book_jongActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="고릴라") {
                    Intent intent = new Intent(getActivity(), Book_goActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="무지개 물고기") {
                    Intent intent = new Intent(getActivity(), Book_muActivity.class);
                    startActivity(intent);
                }
                else if(data.get(position).getBookName()=="도깨비를 빨아버린 우리 엄마") {
                    Intent intent = new Intent(getActivity(), Book_dowActivity.class);
                    startActivity(intent);
                }


            }
        });


      return rootView;
    }
    @Override
    public void onClick(View v) {

    }
}
