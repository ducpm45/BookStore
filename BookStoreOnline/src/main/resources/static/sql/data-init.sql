use book_store;
#### tbl_users ####
insert into tbl_users (user_address, user_email, user_enable, user_full_name, user_password, user_phone,
                       user_role, user_verification_code)
values ('BookStore', 'admin@gmail.com', true, 'admin', 'admin', '0708126730', 'ADMIN', null),
       ('Hà Nội', 'guest1@gmail.com', true, 'Phạm Minh Đức', '123456', '0708126000' , 'CUSTOMER', null),
       ('Thanh Hóa', 'guest2@gmail.com', true, 'Phạm Minh Nguyệt', '123456', '0708126001', 'CUSTOMER',
        null),
       ('Bắc Giang', 'guest3@gmail.com', true, 'Nguyễn Thị Thủy', '123456', '0708126002', 'CUSTOMER',
        null),
       ('Nghệ An', 'guest4@gmail.com', true, 'Nguyễn Văn Ngôn', '123456', '0708126003', 'CUSTOMER', null),
       ('Vĩnh Phúc', 'guest5@gmail.com', true, 'Lê Thọ Dũng', '123456', '0708126004', 'CUSTOMER', null),
       ('Ninh Bình', 'guest6@gmail.com', true, 'Bùi Văn Thanh', '123456', '0708126005', 'CUSTOMER', null),
       ('Hải Phòng', 'guest7@gmail.com', true, 'Lê Thị Ngà', '123456', '0708126006', 'CUSTOMER', null),
       ('Thái Bình', 'guest8@gmail.com', true, 'Trần Thị Thảo', '123456', '0708126007', 'CUSTOMER', null),
       ('Nam Định', 'guest9@gmail.com', true, 'Trương Văn Hùng', '123456', '0708126008', 'CUSTOMER',
        null);

#### tbl_categories ####
insert into tbl_categories (category_name)
values ('Văn học'),
       ('Kinh tế'),
       ('Khoa học - Công nghệ'),
       ('Kỹ năng sống'),
       ('Y học - Sức khỏe'),
       ('Danh nhân - Văn hóa'),
       ('Lịch sử - Quân sự'),
       ('Chính trị - Triết học'),
       ('Phong thủy'),
       ('Ngoại ngữ');

#### tbl_books ####
insert into tbl_books (book_about, book_author, book_discount, book_category_id, book_image, book_language,
                       book_name, book_price, book_publish_date, book_publisher, book_quantity)
values ('Nếu bạn có thể dành hàng giờ trong các hiệu sách nhỏ, thích một cuốn sách hay,
        yêu mùi sách và thường tìm đến thư viện để thư giãn, thì Một thư viện ở Paris là cuốn sách dành cho bạn.
Dựa trên câu chuyện có thật trong Thế chiến thứ Hai về những thủ thư anh hùng của Thư viện Hoa Kỳ ở Paris,
        Một thư viện ở Paris của Janet Skeslien Charles kể về một câu chuyện khó quên về tình yêu đầy lãng mạn,
        tình bạn và gia đình trong tình cảnh bi đát và tăm tối nhất. Cuốn sách xoay quanh người phụ nữ Pháp như Odile. Cô ấy yêu mọi thứ về sách cũng như thư viện. Cô ấy đã ghi nhớ hệ thống Dewey Decimal,
        thậm chí, cô ấy còn bị mê mẩn cả mùi của những cuốn sách.
Với Odile, năm 1939, dường như là một năm hoàn hảo dành cho cô,
        cô đã đạt được thành công trong sự nghiệp và tìm thấy hạnh phúc của mình. Cô đã nhận được công việc mà bấy lâu mình hằng mơ ước đó là trở thành thủ thư của Thư viện Hoa Kỳ ở Paris,
        đồng thời gặp và yêu một cảnh sát quyến rũ người Pháp. Tuy nhiên, khi Đức Quốc xã tiến vào và chiếm đóng Paris,
        mọi thứ thay đổi, không chỉ với Odile mà còn với tất cả người dân của thành phố.
Các thư viện trở thành mục tiêu để Phát xít thôn tính về văn hóa,
        chúng yêu cầu những thư viện tiêu hủy những cuốn sách và những tài liệu mà chúng cho là không phù hợp và độc hại,
        ảnh hưởng đến chế độ hoặc những cuốn sách mà tác giả là người Do Thái. Người Do Thái cũng bị cấm vào những khu vực nhất định trong đó có thư viện,
        và một số thư viện buộc phải đóng cửa. Nhưng Thư viện Hoa Kỳ ở Paris vẫn quyết tâm mở cửa và tiếp tục hoạt động bằng cách giao sách đến tận tay những người không được phép vào bên trong,
        cũng như gửi đi các tài liệu đọc bị cấm thay vì tiêu hủy chúng.
Trong những năm sau đó, những bi kịch liên tiếp xảy ra,
        tác động đến những quyết định trong cuộc đời của Odile: việc người anh em song sinh của cô bị bắt khi tham gia trận chiến,
        những biến cố xảy ra cho người bạn và cũng là người đắc lực giúp đỡ cô hoàn thành những công việc ở thư viện,
        và khi chiến tranh kết thúc, Odile đã phản bội cô ấy, khiến Odile không thể ở lại đây,
        ở lại Paris yêu quý của mình. Cô kết hôn với một người lính Mỹ và chuyển đến Montana, nơi cô sống nhiều năm trong cô đơn như một người ngoài cuộc.
Năm 1983, khi viết một bài nghiên cứu về nước Pháp, Lily,
        mười ba tuổi gõ cửa nhà người hàng xóm bí ẩn. Cô bé tò mò về cuộc sống của Odile và lý do tại sao cô ấy rời khỏi Pháp,
        nhưng Odile hiếm khi kể về quá khứ của mình. Trong những tháng ngày tới,
        một tình bạn bền chặt sẽ được hun đúc. Cùng nhau, Odile và Lily từ từ đối mặt với hậu quả của những lựa chọn trong quá khứ và hiện tại.
Cuốn tiểu thuyết là sự đan xen một cách tuyệt vời giữa Paris trong Thế chiến thứ Hai những năm 1940 và thị trấn nhỏ Montana những năm 1980. Thật hấp dẫn khi xem cận cảnh cuộc chiến trong Thế chiến thứ hai của Odile ở Paris,
        thông qua những trải nghiệm đáng sợ của chính nhân vật, cũng như tầm nhìn xa trông rộng của Lily,
        những gì cô bé đã học được trong lớp lịch sử. Với tư cách là độc giả, chúng ta nhìn cuộc chiến bằng lăng kính của hiện tại và tương lai – lịch sử sống lại và sau đó được làm sáng tỏ từ nhiều thập kỉ trong tương lai.
Đây là một câu chuyện phi thường về tình yêu, sự hy sinh, sự phản bội,
        lòng đố kị và cả sự tha thứ cho Odile cũng như Lily. Nó làm sáng tỏ những thực tế về cảm xúc thông qua tình yêu với chữ viết,
        thông qua nhu cầu của con người về sách và truyện. Hai cốt truyện kết hợp với nhau cho thấy cái nhìn sâu sắc về các mối quan hệ và tình bạn vượt thời gian và không gian. Quan trọng nhất,
        cuốn tiểu thuyết giúp chúng ta thấy rằng mọi thứ thường không giống như những gì chúng có vẻ là. Và, đó là một sự pha trộn tuyệt đẹp giữa thực tế và hư cấu.
Ngoài ra, Một thư viện ở Paris còn cho phép chúng ta nhìn rộng hơn về một thời gian khác,
        không gian khác và cuộc sống khác – một số chúng ta mơ ước,
        một số khác chúng ta sợ hãi – nhưng cuốn sách này sẽ chạm đến trái tim bạn. Nó khiến bạn muốn vượt ra ngoài các trang sách,
        khiến bạn phải ngạc nhiên,
        khiến bạn bật khóc hoặc mỉm cười. Cuốn sách cũng như một lời nhắc nhở rằng định nghĩa về anh hùng rất rộng. Có rất nhiều anh hùng thầm lặng – và cả các nữ anh hùng – đã làm những điều phi thường,
        có những hi sinh phi thường, nhưng câu chuyện về những người thủ thư này và những người bảo trợ của họ (dựa trên những con người và tình huống có thật) là hoàn toàn độc đáo và đáng kinh ngạc.',
        'Janet Skeslien Charles', 0, 1, 'static/img/mot-thu-vien-o-paris.jpg', 'Tiếng Việt',
        'Một thư viện ở Paris', 235000, '2022-07-17', 'NXB Văn học', 100),
       ('Đoàn kết như sói, tạo dựng tập thể trên dưới một lòng,
        muôn người như một .Con sói đầu đàn tốt hay xấu sẽ quyết định đàn sói của nó tốt hay xấu,
        một con Sói đầu đàn ưu tú có thể tạo ra được một đàn Sói ưu tú,
        một đội Sói ưu tú. Loài sói như nào thì tập thể doanh nghiệp cũng như vậy. Người lãnh đạo một doanh nghiệp là lá cờ đầu của tập thể,
        là linh hồn của tập thể. Một tập thể doanh nghiệp có được coi là tập thể ưu việt không,
        có thể thoát ra từ trong các cuộc cạnh tranh khốc liệt hay không đều phụ thuộc trực tiếp vào người lãnh đạo tập thể. Chỉ có tập thể được dẫn dắt bởi một người lãnh đạo ưu tú thì mới trở thành một tập thể ưu tú.',
        'Phạm Nhung', 0, 2, 'static/img/tri-tue-loai-soi-tb-2022.jpg', 'Tiếng Việt',
        'Trí Tuệ Loài Sói - Doanh Nghiệp Tạo Dựng Tập Thể Xuất Sắc Như Thế Nào? (Tái bản năm 2022)', 150000,
        '2022-06-17', 'NXB Dân Trí', 100),
       ('Sách - Bách khoa toàn thư khoa học
Tại sao pháo lại nổ được? Các loài cây sử dụng ánh sáng mặt trời để tạo ra chất dinh dưỡng như thế nào? điều gì mang lại trí thông minh cho robot? Tất cả các vấn đề đó đều được giải thích và trình bày trong cuốn bách khoa toàn thư khoa học này.
Với vô số những thông tin thú vị và hình ảnh tuyệt đẹp, bách khoa toàn thư khoa học đã khiến cho vật lý, hóa học,
        sinh học, trở nên gần gũi.',
        'Nhiều tác giả', 0, 3, 'static/img/bach-khoa-toan-thu-khoa-hoc.jpg', 'Tiếng Việt',
        'Sách - Bách khoa toàn thư khoa học', 430000, '2022-07-18',
        'Công ty CP Đầu tư và Phát triển giáo dục quốc tế Á Châu', 100),
       ('Giao tiếp là một hình thức kết nối thiết yếu trong cuộc sống thường ngày nhưng với những người không “giỏi ăn,
        giỏi nói” thì mỗi cuộc trò chuyện hẳn là cơn ác mộng mà bạn chỉ muốn thoát ra thật nhanh. Nghĩ đến việc “Phải loay hoay để tìm ra được cách mở lời”,
        “Nói chuyện thông thường mà như phỏng vấn vậy!”, “Sao để lấp đầy khoảng lặng kì cục này?” khiến bạn mệt mỏi không còn sức lực.

Nụ cười thật tươi không còn là phương pháp đối phó hữu hiệu trong tất cả trường hợp,
        sự im lặng không tạo nên bầu không khí dễ chịu, các mối quan hệ không thể tiếp tục vì đơn giản là… không còn hứng thú để trò chuyện nữa. Vậy đâu là mấu chốt khiến việc giao tiếp của bạn đi vào “ngõ cụt”? Làm thế nào để “cấp cứu” những câu chuyện nhàm chán? Làm sao để người khác luôn thích được chia sẻ với bạn?

Giao Tiếp Cơ Bản - Cẩm Nang Làm Chủ Mọi Cuộc Trò Chuyện sẽ là nền tảng vững chắc giúp bạn thoát khỏi sự bế tắc trong giao tiếp,
        kiểm soát được bầu không khí khi trò chuyện, nắm bắt tâm lý đối phương từ đó biến những phút giây lúng túng trở nên vui vẻ và thú vị.

Mong rằng, sau khi “nhẩm” hết cuốn sách này, bạn có thể tự tin nói rằng: “Thật ra,
        trò chuyện hay kết nối cũng có gì khó khăn lắm đâu nhỉ?”',
        'Tatsunari Iota', 0, 4, 'static/img/giao-tiep-co-ban.jpg', 'Tiếng Việt',
        'Giao Tiếp Cơ Bản - Cẩm Nang Làm Chủ Mọi Cuộc Trò Chuyện', 129000, '2022-08-15', 'NXB Thế Giới',
        100),
       ('Cơ thể tự chữa lành - Giải cứu gan là cuốn sách tiếp theo trong bộ sách Cơ thể tự chữa lành của tác giả có sách bán chạy số 1 theo New York Times bình chọn: Anthony William. Trong tác phẩm mới này,
        ông sẽ hé mở bức màn bí mật về đặc điểm, cơ chế hoạt động và những điều bí ẩn xoay quanh lá gan của con người.
Trong thế giới hiện đại, chúng ta không hề biết rằng có bao nhiêu triệu chứng,
        tình trạng và bệnh lý bắt nguồn từ một lá gan quá tải, trì trệ và ứ đọng. Không chỉ có ung thư gan,
        xơ gan và viêm gan. Gần như mọi khổ sở về sức khỏe – từ vấn đề sức khỏe tổng thể, vấn đề về tiêu hóa,
        bất ổn về cảm xúc, tăng cân bất thường, cao huyết áp, vấn đề tim mạch, sương mù não, vấn đề về da, tới các bệnh mạn tính và tự miễn khác – đều có nguồn gốc sâu xa từ một lá gan bị tổn thương.

Cơ thể tự chữa lành - Giải cứu gan mang tới cho người đọc lời giải và cách xử lý khi phải đối mặt với nhiều thách thức về thể chất cũng như tinh thần. Với lòng trắc ẩn sâu sắc,
        Anthony William đã hào phóng chia sẻ với tất cả chúng ta những thông tin độc nhất vô nhị về hàng ngàn chức năng bí ẩn của gan,
        giải thích nguyên nhân cốt tủy của hàng loạt vấn đề sức khỏe đang kìm hãm chúng ta,
        đồng thời hướng dẫn chi tiết cách khắc phục và giải quyết chúng,
        để ta có thể sống thực sự khỏe mạnh và hạnh phúc. Tìm hiểu cách thức giải cứu gan chính là chuẩn bị cho bản thân một tâm trí rõ ràng,
        một tinh thần ổn định và một thân thể khỏe mạnh để ứng phó với cuộc sống tất bật và đầy rẫy khó khăn hiện nay. Học cách giải cứu gan còn là học cách ngủ ngon,
        cân bằng đường huyết, hạ huyết áp, giảm cân, và trông tươi trẻ hơn.

Một lá gan khỏe mạnh sẽ là đồng minh trung thành và tận tụy của chúng ta trên hành trình đến với con người tốt đẹp nhất của mình.',
        'Anthony William', 0, 5, 'static/img/co-the-tu-chua-lanh-giai-cuu-gan.jpg', 'Tiếng Việt',
        'Cơ Thể Tự Chữa Lành: Giải Cứu Gan', 166000, '2022-07-30', 'NXB Thanh Niên', 100),
       ('Tác giả cuốn sách là người công tác nhiều năm ở cơ quan Tổng hành dinh từ ngày thành lập năm 1945,
        là nhà nghiên cứu lịch sử quân sự và lịch sử chiến tranh cách mạng có uy tín lớn, dành nhiều năm để nghiên cứu về cuộc đời cầm quân của Đại tướng Võ Nguyên Giáp. Cuốn sách Võ Nguyên Giáp - Danh tướng thời đại Hồ Chí Minh là kết quả của quá trình nghiên cứu đó.
Là người trong cuộc - một nhân chứng lịch sử - bằng những tư liệu lịch sử chân thực cả về phía ta và phía địch,
        từ thực tế xây dựng, chiến đấu,
        chiến thắng và trưởng thành của quân độ ta trong cuộc kháng chiến chống thực dân Pháp xâm lược,
        tác giả đã trình bày quá trình Đại tướng - Tổng tư lệnh Võ Nguyên Giáp,
        dưới sự lãnh đạo của Đảng và Bác Hồ vĩ đại,
        đã chỉ huy toàn quân đánh thắng quân đội xâm lược nhà nghề của đế quốc Pháp, làm nên chiến thắng lịch sử Điện Biên Phủ.
Cuốn sách nhấn mạnh đến vai trò, trọng trách cầm quân của Đại tướng Võ Nguyên Giáp dưới sự lãnh đạo của Đảng,
        được Bác Hồ trao cho cẩm nang làm tướng, ông đã quán triệt chiến tranh nhân dân toàn diện và trường kỳ, đứng vững trên nền tảng chính trị của khối đại đoàn kết toàn dân để dẫn dắt toàn quân đi từ thắng lợi này đến thắng lợi khác trong suốt 30 năm chiến tranh giải phóng.
Đức độ và tài năng của Đại tướng Võ Nguyên Giáp đã đem lại cho ông niềm tin yêu trọn vẹn của toàn Đảng, toàn dân,
        toàn quân, lòng mến mộ của bạn bè quốc tế và cả sự khâm phục của những người hôm qua còn là đối thủ của ông.
Với những trang sách này, chúng ta mới cảm nhận được những nét phác thảo chặng đường cầm quân của Tổng tư lệnh Võ Nguyên Giáp trong suốt cuộc trường chinh đánh thắng hai đế quốc lớn.',
        'Trần Trọng Trung', 0, 6, 'static/img/vo-nguyen-giap-danh-tuong-thoi-dai-hcm.jpg', 'Tiếng Việt',
        'Võ Nguyên Giáp Danh Tướng Thời Đại Hồ Chí Minh', 257000, '2022-06-25',
        'NXB Chính Trị Quốc Gia Sự Thật', 100),
       ('Sử ký là bộ thông sử đầu tiên của Trung Quốc cổ đại. Bộ sử ký lưu giữ, chỉnh lí lại các tư liệu lịch sử vô cùng phong phú trong hơn ba ngàn năm từ thời Ngũ đế vốn có trước sử cho tới giữa thời Tây Hán.

Ấn bản này với hình thức mới mẻ, toàn diện, góc nhìn mới, đa tầng,
        giúp bạn đọc hiểu rõ hơn nguyên tác. Cuốn sách còn có phần phụ như giải thích, dịch nghĩa bằng câu từ tinh tế giúp bạn đọc thưởng thức trọn vẹn nội dung tác phẩm.',
        'Tư Mã Thiên', 0, 7, 'static/img/su-ky-tu-ma-thien.jpg', 'Tiếng Việt', 'Sử Ký Tư Mã Thiên (Bìa Cứng)',
        228000, '2022-07-20', 'NXB Văn học', 100),
       ('Trung Quốc là một quốc gia lớn trên thế giới, có bề dày truyền thống lịch sử và văn hóa,
        với nền văn minh Trung Hoa là một trong những nền văn minh phát triển rực rỡ nhất thế giới cổ trung đại. Trung Quốc là quốc gia có diện tích lục địa lớn thứ tư trên thế giới chỉ sau Liên bang Nga,
        Canada và Mỹ. Diện tích hiện nay của Trung Quốc rộng khoảng 9.596.961 km2,
        có đường biên giới trên bộ dài nhất thế giới, với 22.117km, tiếp giáp với 14 quốc gia, gồm: Triều Tiên, Nga,
        Mông Cổ, Nepal, Buthan, Ấn Độ, Pakistan, Afganistan, Tadjikistan, Kyrgyzstan, Kazakhstan, Việt Nam, Lào,
        Myanmar.
            Đến tháng 9/2019,
        Trung Quốc đã có quan hệ ngoại giao với 180 nước (kể cả Palestine, quần đảo Cook và Niue). Chính sách ngoại giao của Trung Quốc là “5 nguyên tắc cùng tồn tại hòa bình” có từ thời Thủ tướng Chu Ân Lai. Tuy nhiên,
        trong hơn 70 năm qua (1949-2020),
        đường lối và chính sách ngoại giao của Trung Quốc không hoàn toàn tuân thủ theo nguyên tắc đó, nhất là trong quan hệ biên giới – lãnh thổ với các quốc gia láng giềng.

Vì vậy,
        nghiên cứu về Quan hệ biên giới trên đất liền giữa Trung Quốc với các quốc gia láng giềng không chỉ đơn thuần mang ý nghĩa khoa học,
        mà còn thông qua đó,
        góp phần làm rõ hơn về chính sách và hành động của chính quyền Bắc Kinh trong quan hệ biên giới – lãnh thổ với các nước láng giềng. Các nghiên cứu và công bố về vấn đề này sẽ là một đóng góp về mặt sử học trong cuộc đấu tranh vì hòa bình hữu nghị tại các khu vực biên giới trên bộ và trên biển giữa các quốc gia trên thế giới và khu vực nói chung,
        giữa Trung Quốc và Việt Nam nói riêng.

Để góp thêm chút sức lực nhỏ bé vào quá trình nghiên cứu và nâng cao hiểu biết về lĩnh vực quan hệ biên giới, lãnh thổ,
        chủ quyền dân tộc nói riêng, cũng như lĩnh vực sử học và xây dựng chính sách nói chung,
        nhất là trong mối quan hệ với Trung Quốc, một nước lớn ở khu vực và trên thế giới,
        MaiHaBooks trân trọng giới thiệu đến quý độc giả cuốn sách Quan hệ biên giới trên đất liền giữa Trung Quốc với các quốc gia láng giềng. Hy vọng cuốn sách sẽ là một trong những chuyên khảo đặc sắc để mỗi độc giả tìm tòi và nghiền ngẫm.',
        'Đinh Quang Hải', 0, 8,
        'static/img/quan-he-bien-gioi-tren-dat-lien-giua-trung-quoc-va-cac-quoc-gia-lang-gieng.jpg', 'Tiếng Việt',
        'Quan Hệ Biên Giới Trên Đất Liền Giữa Trung Quốc Với Các Quốc Gia Láng Giềng', 259000, '2022-05-25',
        'NXB Khoa Học - Xã Hội', 100),
       ('Nghệ thuật ứng dụng kiến thức Chiêm tinh học vào cuộc sống.

Tất cả những kiến thức ta thu nạp hằng ngày qua sách vở không ngoài mục đích phục vụ cho chính cuộc sống của chúng ta. Chiêm tinh học cũng thế. Không chỉ là việc tính cách của chòm sao này như thế nào,
        khi yêu cách cư xử của bạn theo cung hoàng đạo sẽ ra sao,
        … mà dùng các kiến thức đó áp dụng vào thực tế cuộc sống, thấu hiểu mọi người xung quanh, cải thiện các mối quan hệ và có một cuộc sống tốt đẹp hơn mới là mục đích sau cùng.

Gary Holdschneider đã kết hợp giữa nghệ thuật Chiêm tinh từ cổ đại với kiến thức Tâm lý học hiện đại để tạo nên một cuốn sách hướng dẫn vô cùng cụ thể về cách xử lý các tình huống theo cung hoàng đạo. Thay vì tìm hiểu và khám phá bản thân,
        cuốn sách hướng đến việc hướng dẫn độc giả làm thế nào để tương tác với 11 cung hoàng đạo còn lại trong nhiều hoàn cảnh khác nhau.

Nội dung được chia nhỏ dựa trên ba bối cảnh: Bối cảnh công việc, bối cảnh tình yêu,
        cuối cùng là bối cảnh gia đình và bạn bè. Ba bối cảnh lớn đó phân loại thành tất cả 16 đối tượng bạn có quan hệ trong cuộc đời: Sếp,
        nhân viên, đồng nghiệp, khách hàng, đối tác, đối thủ, buổi hẹn hò đầu tiên, người yêu, bạn đời, người yêu cũ,
        bạn bè, bạn cùng phòng, bố mẹ, anh chị em, con cái.

Nắm bắt được những điểm mạnh, điểm yếu và phong cách ứng xử của từng cung hoàng đạo chắc chắn sẽ giúp bạn thấu hiểu và cải thiện mọi mối quan hệ hàng ngày.',
        'Gary Goldschneider', 0, 9, 'static/img/chiem-tinh-hoc-ung-dung.jpg', 'Tiếng Việt',
        'Chiêm Tinh Học Ứng Dụng', 350000, '2022-07-16', 'NXB Thế Giới', 100),
       ('Đây là bộ giáo trình được biên soạn dành riêng cho học sinh trung học với mục tiêu hướng dẫn các em luyện tập để đạt điểm cao khi thi IELTS cũng như nâng cao khả năng sử dụng tiếng Anh. Trên cơ sở bám sát yêu cầu của bài thi IELTS,
        bộ giáo trình này bồi dưỡng cả bốn kỹ năng nghe, nói, đọc và viết thông qua các chủ đề phổ biến và trình độ phù hợp với học sinh trung học.

Bộ giáo trình bao gồm bốn cấp độ: pre-intermediate, intermediate, upper - intermediate và advanced, mỗi cấp độ có hai quyển.

-  Cấp độ pre-intermediate phù hợp với học sinh dự định thi IELTS đạt 4.0

-  Cấp độ intermediate phù hợp với học sinh dự định đạt 4.5-5.0

-  Cấp độ upper-intermediate dành cho các em mong muốn đạt 5.0-5.5

-  Cấp độ advanced đáp ứng nhu cầu của các em đặt mục tiêu 6.0-6.5.

Đặc điểm của bộ sách:

Bám sát xu hướng ra đề mới nhất của bài thi IELTS
Chú trọng rèn luyện cả kiến thức ngôn ngữ lẫn bốn kỹ năng
Được biên soạn theo hướng trình bày kiến thức kèm nhiều bài tập thực hành
Gần gũi với chương trình học và cuộc sống của học sinh trung học
Giúp học sinh ôn tập, củng cố kiến thức, phát triển năng lực tiếng Anh và nâng cao dần theo giai đoạn
Có độ khó vừa phù hợp với trình độ của học sinh trung học vừa đáp ứng yêu cầu của bài thi IELTS thực tế
Trang web online.nhantriviet.com cung cấp vô số bài thực hành giúp học sinh phát triển toàn diện bốn kỹ năng tiếng Anh
Online flashcard hỗ trợ học sinh ghi nhớ từ một cách dễ dàng và có hệ thống',
        'Vicky Liu', 0, 10, 'static/img/ielts-trung-hoc-pre-intermediate-book-2.jpg', 'Tiếng Việt',
        'IELTS Trung Học - Pre-intermediate - Book 2', 268000, '2022-08-12', 'NXB Tổng Hợp TP. HCM', 100);
