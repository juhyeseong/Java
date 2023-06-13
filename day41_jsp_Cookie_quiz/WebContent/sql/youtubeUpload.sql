
--youtube ����� ������� DB�� ����
--���󸶴� DB������ ������ȣ�� �ο�
--��Ű�� Ȱ���Ͽ� �ֱ� ������ ������
--������ ������ ǥ��Ǿ�� ��
-------------------------------------------------------------------------------------------------------
set define off;

drop table youtube_list purge;
drop sequence youtube_list_seq;

create sequence youtube_list_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocache
    nocycle;

create table youtube_list (
    idx		nubmer		default youtube_list_seq.nextval primary key,
    title	varchar2(500)	not null,
    channel	varchar2(100)	not null,
    thumbnail	varchar2(500)	not null,    
    iframe	varchar2(500) 	not null
);

insert into youtube_list (title,channel,thumbnail,iframe)
    values (
	'������ź �����̶�?',
	'ħ����',
	'https://i.ytimg.com/vi/8ApNfUJwobs/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBHxL440ij_VqKcDsM-DVjdvYO_7w',
	'<iframe width="704" height="396" src="https://www.youtube.com/embed/8ApNfUJwobs" title="������ź �����̶�?" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>'
);

insert into youtube_list (title, channel, thumbnail, iframe)
    values (
	'[�ڸ�����] �ڷγ� Ư�� ������... ',
	'JTBC News',
	'https://i.ytimg.com/vi/GH9--zGwqbo/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAwKh0_I0s_5AyjtBez4dGR82Y-mw',
	'<iframe width="704" height="396" src="https://www.youtube.com/embed/GH9--zGwqbo" title="[�ڸ�����] �ڷγ� Ư�� �����١��� ���� ���ݿ� ���� &#39;����&#39; Ȯ�� / JTBC News" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>'
);

