create table users(
	uuid	varchar(100)	primary key,
	upw	varchar(100)	not null,
	uname	varchar(100)	not null,
	uph	varchar(100)	not null,
	uem	varchar(100)	not null,
	uaddr	varchar(200)	not null,
	uathu	int
);
create table follows(
	fnum     varchar(200) primary key,
	follower varchar(100) references users(uuid) on delete cascade,
	followed varchar(100) references users(uuid) on delete cascade
);
create table products(
	pnum int primary key,
	puid varchar(100) references users (uuid) on delete cascade,
	pname varchar(1000),
	ptext varchar(3000),
	pprice int,
	pstock int default 0
);
create table reviews(
	rnum int primary key,
	rpnum int references products (pnum) on delete cascade,
	ruid varchar(100),
	rtext varchar(3000),
	rdate date default sysdate
);
create table articles(
	anum int primary key,
	atitle varchar(1000),
	auid varchar(100),
	auname varchar(100),
	atext varchar(3000),
	adate date default sysdate
);
create table comments(
	cnum	int		primary key,
	canum	int 	references articles (anum) on delete cascade,
	cuid	varchar(100),
	ctext	varchar(3000),
	cdate	date	default sysdate
);

insert into users values('admin','1234','관리자도자기','010-1234-5678','admin@gmail.com','서울시 강남구',1);
insert into users values('user1','1234','무자기','010-0000-0000','user1@naver.com','경기도 성남시',1);
insert into users values('user2','1234','단아단아','010-1111-1111','user2@hanmail.net','서울시 종로구',1);

insert into follows values('admin_user1','admin','user1');
insert into follows values('admin_user2','admin','user2');
insert into follows values('user1_admin','user1','admin');

insert into products values((select NVL(max(pnum),0)+1 from products),'admin','블루라인 사각찬기','테두리를 따라 그려진 선명한 푸른 선이 산뜻한 포인트가 되는 김석빈도자기의 블루라인 정사각찬기입니다. 캐주얼하면서도 모던한 감성이 돋보이는 그릇으로 바닥에서 위로 갈수록 사선으로 넓어지는 형태의 사각접시로 찬기나 앞접시로 쓰기 좋은 크기입니다. 굽없이 평평한 바닥의 뒷면은 유약처리가 되어 있지 않아 매트한 느낌입니다.',20000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'admin','블루라인 사각볼','바닥에서 위로 갈수록 넓어져 넉넉하게 담을 수 있는 김석빈도자기 사각볼입니다. 면의 테두리마다 짙은 블루라인이 모던테이블을 완성시켜줍니다. S, M, L 세 가지 크기로 깊이감이 있는 볼이라 넉넉하게 요리를 담을 때 활용도 높으며, 샐러드볼, 면기, 덮밥그릇으로 사용하기 좋고, 갈비찜, 닭볶음탕 등 국물이 있는 한식요리를 담아도 감각적이랍니다.',28000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'admin','블루라인 손잡이 원형접시','그릇의 양쪽 끝에 달린 귀여운 손잡이가 돋보이는 김석빈도자기의 블루라인 손잡이 원형접시입니다. 마치 얼굴에 귀가 달린 것처럼 앙증맞은 형태와 손맛이 느껴지는 자연스러운 라인이 만나 포 하면서도 캐주얼한 감성이 전해집니다.',28000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'admin','블루라인 각머그','면과 면이 만나는 선과 테두리마다 짙은 블루라인이 그어진 김석빈도자기 각머그입니다. 한 번에 면을 깎아내지 않아 울퉁불퉁하거나 패임이 있어 각머그만의 소탈한 매력을 더 진하게 만들어줍니다.',36000,10);

insert into products values((select NVL(max(pnum),0)+1 from products),'user1','무자기 백자 꽃찬기','길가에 핀 꽃을 모티브로 간결하면서도 디테일을 살린 심보근 작가의 백자 꽃찬기입니다.꽃잎이 4장, 6장인 그릇은 잎의 모양이 갈래갈래 살아 있어 형태적 재미가 돋보이며, 풍성한 꽃잎의 결을 표현한 다잎 그릇까지 세가지 스타일이 있습니다',19000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user1','무자기 무궁화 미니접시','무궁화를 모티브로 한 심보근 작가의 백자 플레이트 겸 수저받침입니다.간결하면서도 디테일을 살려 차분한 감성이 돋보이는 작품으로 사이즈가 아담하니 꼭 확인하세요. (지름9.5cm)',12000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user1','무자기 백자 꽃볼 세트','길가에 핀 꽃을 모티브로 간결하면서도 디테일을 살린 심보근 작가의 백자 꽃볼입니다. 풍성한 꽃잎의 결이 느껴지는 둥근 볼로 면기, 샐러드볼, 메인요리용 그릇 등으로 다양하게 활용하기 좋은 그릇입니다.',39000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user1','무자기 티스푼 수저받침','길가에 핀 꽃을 모티브로 간결하면서도 디테일을 살린 심보근 작가의 스푼입니다. 앙증맞은 사이즈로 아이스크림 스푼, 요거트 스푼으로 사용하거나 수저받침으로 활용하셔도 좋습니다.',10000,10);

insert into products values((select NVL(max(pnum),0)+1 from products),'user2','단아한 오목 굽찬기','밑굽이 있는 오목한 원형 찬기입니다. 약간 푸른빛을 띄는 백자로 콕콕 박힌 철점이 매력적인 이 찬기는 적당한 굽이 평범한 반찬도 돋보이게 해준답니다.',12000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user2','도자기 술잔 와인잔','단아함이 느껴지는 라인과 하얀 백자에 콕콕 박힌 철점이 매력적인 컵을 소개합니다. 와인잔, 막걸리잔, 사케잔 등으로 사용해도 좋고, 아이스크림, 씨리얼, 과일 등을 담는 용도로 활용하면 테이블에 활기가 더해집니다.',20000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user2','단아한 공기 대접 세트','복스러운 둥근 라인과 적당한 굽이 균형감을 이루는 지인식 작가의 공기와 대접입니다. 약간 푸른빛을 띄는 백자로 콕콕 박힌 철점이 자연스러운 멋을 전해주며, 전통과 모던, 어느 쪽에 놓아도 어울릴 깔끔한 디자인이라 오래도록 사랑하며 사용할 수 있습니다.',36000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user2','단아한 각면기','사선으로 떨어지다 각을 그리는 라인이 모던한 면기입니다. 약간 푸른빛을 띄는 백자로 콕콕 박힌 철점이 포근함을 전해주며, 전통과 모던, 어느 쪽에 놓아도 어울릴 깔끔한 디자인이라 오래도록 사랑하며 사용할 수 있습니다.',24000,10);

insert into products values((select NVL(max(pnum),0)+1 from products),'admin','그림담은 디저트 굽접시','순백의 도자기에 섬세한 민화를 그려넣은 전상우 작가의 디저트 굽접시입니다 그릇 위에는 국화, 나뭇잎이 그려져 있으며 다식 접시로 사용하면 좋은 사이즈입니다.',40000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'admin','그림담은 원형 굽접시','일반적인 청화도자기와 달리 먼저 흙으로 밑그림을 그린 뒤 푸른 안료를 일일이 채워 넣어 하나의 작품 같은 도자기를 완성하였습니다. 꽃잎 하나하나에서 느껴지는 입체적인 질감과 디테일한 표현은 어디에서도 볼 수 없는 작가만의 독창적인 기법입니다.',45000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'admin','그림담은 다용도잔','순백의 도자기에 섬세한 민화를 그려넣은 전상우 작가의 다용도 잔입니다. 당귀, 나뭇잎, 유칼립투스 중 선택하실 수 있습니다. 술잔이나 찻잔, 혹은 디저트볼로 사용하셔도 좋습니다.',36000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'admin','그림담은 사각찬기','반듯반듯 개성있는 형태에 그림을 그려 넣어 식탁에 활기를 불어넣어 줍니다.',24000,10);

insert into products values((select NVL(max(pnum),0)+1 from products),'user2','화사한 미니 화병','은은한 옥빛 색감과 도트 장식이 돋보이는 심지수 작가의 미니 화병입니다. 물방울 형태의 미니 화병에 작은 꽃 한 송이를 꽂아 식탁에 활기를 줘 보세요.',30000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user2','화사한 라인 공기 대접','은은한 옥빛 색감과 섬세한 장식이 돋보이는 심지수 작가의 공기, 대접입니다. 그릇의 표면을 직선으로 가늘게 파내어 섬세한 라인을 새겨넣운 것이 특징입니다. 밑으로 갈수록 살짝 넓어지다 밑굽 부분에서는 다시 좁아지는 형태로 넉넉하게 담을 수 있는 그릇입니다.',28000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user2','화사한 복종지 미니찬기','은은한 옥빛 색감과 테두리의 도트 장식이 돋보이는 심지수 작가의 복종지입니다. 복스러운 형태감과 테두리를 따라 흙으로 하나하나 점을 찍어 올린 디테일이 매력적입니다. 소스볼, 미니찬기 등으로 사용해보세요.',16000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user2','화사한 라인 타원볼','은은한 옥빛 색감과 섬세한 무늬가 돋보이는 심지수 작가의 타원볼입니다. 그릇의 표면을 직선으로 가늘게 파내어 라인을 새겨넣었습니다. 샐러드볼이나 유아용 덮밥 그릇으로 사용해 보세요.',30000,10);

insert into products values((select NVL(max(pnum),0)+1 from products),'user1','스며들다 디저트볼','투각기법을 통해 빛을 담아낸 박지영 작가의 스며들다 시리즈 요거트볼입니다. 꽃잎 사이 사이로, 혹은 나뭇잎 문양으로 스미는 빛이 식탁을 따스하게 감싸줍니다. 요거트볼이나 아이스크림볼로 사용하기 좋은 사이즈이며, 노란빛을 띠는 아이보리 색상으로 꽃과 나뭇잎 두 가지 형태 중 고르실 수 있습니다.',35000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user1','스며들다 꽃찻잔','투각기법을 통해 빛을 담아낸 박지영 작가의 스며들다 시리즈 꽃찻잔입니다. 꽃잎 사이 사이로 스미는 빛이 식탁을 따스하게 감싸줍니다. 접시로 사용 가능한 소서와 찻잔이 한 세트이며 노란빛을 띠는 아이보리 색상입니다',48000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user1','스며들다 디저트 굽접시','투각기법을 통해 빛을 담아낸 박지영 작가의 스며들다 시리즈 디저트 굽접시입니다. 꽃잎 사이 사이로 스미는 빛이 식탁을 따스하게 감싸줍니다. 노란빛을 띠는 아이보리 색상으로 굽이 있어 특별한 디저트를 내기에 좋습니다.',45000,10);
insert into products values((select NVL(max(pnum),0)+1 from products),'user1','스며들다 면기','투각기법을 통해 빛을 담아낸 박지영 작가의 스며들다 시리즈 면기입니다. 꽃잎 사이 사이로, 혹은 나뭇잎 문양으로 스미는 빛이 식탁을 따스하게 감싸줍니다. 면기나 샐러드볼로 사용하기 좋은 사이즈이며, 노란빛을 띠는 아이보리 색상으로 꽃과 나뭇잎 두 가지 형태 중 고르실 수 있습니다.',80000,10);

insert into reviews(rnum,rpnum,ruid,rtext) values((select NVL(max(rnum),0)+1 from reviews),1,'user1','너무이쁘네요~!!');
insert into reviews(rnum,rpnum,ruid,rtext) values((select NVL(max(rnum),0)+1 from reviews),1,'user2','공짜로 보내주실순 없나요?');
insert into reviews(rnum,rpnum,ruid,rtext) values((select NVL(max(rnum),0)+1 from reviews),2,'admin','저기 계피같은것도 주는건가요?');

insert into articles(anum,atitle,auid,atext,auname) values((select NVL(max(anum),0)+1 from articles),'필기 사이트 최고에요!','user2','제목이 곧 내용이에요',(select uname from users where uuid='admin'));
insert into articles(anum,atitle,auid,atext,auname) values((select NVL(max(anum),0)+1 from articles),'도자기 너무 예쁘네요~','user1','너무 좋네요',(select uname from users where uuid='user1'));
insert into articles(anum,atitle,auid,atext,auname) values((select NVL(max(anum),0)+1 from articles),'로렌입숨','admin','아름답고 힘차게 희망의 얼마나 그림자는 위하여 얼음이 수 영원히 운다. 길을 그들은 밥을 동산에는 그들은 싸인 원질이 것이다. 불어 아니더면, 행복스럽고 품에 고동을 품고 어디 되려니와, 무한한 것이다. 주며, 힘차게 구하지 무엇이 더운지라 이상을 위하여 우리는 살았으며, 것이다. 미인을 때까지 영락과 위하여, 밝은 소담스러운 뿐이다. 피고 무엇이 위하여서 주며, 만물은 피가 능히 이상의 사막이다. 몸이 이 고행을 영락과 더운지라 장식하는 피고 피다. 타오르고 위하여 기쁘며, 밝은 같지 피고, 작고 천자만홍이 수 것이다. 날카로우나 웅대한 있는 공자는 피는 보라. 않는 웅대한 할지라도 장식하는 불어 그림자는 일월과 아름다우냐?',(select uname from users where uuid='user2'));
insert into articles(anum,atitle,auid,atext,auname) values((select NVL(max(anum),0)+1 from articles),'Lorem ipsum dolor','admin','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',(select uname from users where uuid='user2'));

insert into comments(cnum,canum,cuid,ctext) values((select NVL(max(cnum),0)+1 from comments),1,'admin','ㄷㄱㄷㄱ');
insert into comments(cnum,canum,cuid,ctext) values((select NVL(max(cnum),0)+1 from comments),1,'user2','ㄷㄱㄷㄱ2');
insert into comments(cnum,canum,cuid,ctext) values((select NVL(max(cnum),0)+1 from comments),2,'user1','ㅎㅅㅎ');
insert into comments(cnum,canum,cuid,ctext) values((select NVL(max(cnum),0)+1 from comments),3,'admin','계절이 잔디가 그러나 이름자를 아이들의 라이너 까닭입니다. 하나에 아침이 이름자 어머니 멀듯이, 까닭입니다. 잠, 다 하나에 나는 슬퍼하는 가을로 내린 걱정도 이름을 있습니다. 이름을 어머니, 프랑시스 까닭입니다. 오면 나는 지나가는 피어나듯이 내 하나에 다 있습니다. 된 가을 지나고 둘 봅니다. 둘 릴케 된 언덕 불러 밤을 지나가는 별 까닭입니다. 다 써 지나가는 묻힌 소학교 거외다. 멀리 하나에 써 지나가는 별 무성할 거외다. 밤을 보고, 까닭이요, 내 봅니다. 릴케 이름자 별 부끄러운 별 계절이 벌레는 까닭입니다.');
insert into comments(cnum,canum,cuid,ctext) values((select NVL(max(cnum),0)+1 from comments),4,'admin','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

