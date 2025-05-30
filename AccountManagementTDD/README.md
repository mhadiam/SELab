<div dir="rtl">

# مدیریت حساب بانکی

## بخش اول - کشف خطا

- پرسش اول: در این که چه خطایی وجود دارد؟ و به نظر شما چرا دیده نشده است؟ موجودی حساب ممکن است منفی شود. در واقع پیشگیری لازم برای زمانی که میزان برداشت از حساب بیشتر از موجودی حساب است، انجام نشده است. زمانی که درخواست غیرمجاز برای برداشت بیش از موجودی حساب انجام می‌شود، باید درخواست رد شود.

- پرسش دوم: پس از یافتن خطا، یک آزمون برای آن بنویسید که منجر به کشف آن خطا شود. سپس آن را به گونه‌ای اصلاح کنید که آن مورد آزمون، پاس شود. نام تابع آزمون برای کشف خطا `testNegativeBalance`. همچنین تغییرات لازم برای بررسی برداشت بیش از موجودی (که به موجودی منفی می‌انجامد) نیز در تابع `calculateBalance` انجام شده است. این تغییرات با فرض اینکه تراکنش‌ها به صورت متوالی اجرا می‌شوند (یعنی لازم نیست همه با هم اجرا شوند) صورت گرفته. و نیز اگر یک تراکنش انجام نشد می‌توانیم تراکنش بعدی را از لیست تراکنش‌ها اجرا کنیم (این قسمت رو چون واضح نبود با فرض خودم زدم).

تابع `calculateBalance` پس از اصلاحات:


```java
... //before

else if (t.getType() == TransactionType.WITHDRAWAL) {
  if (t.getAmount() < balance) {
      balance -= t.getAmount();
      transactionHistory.add(t);
  }
}

... //after
```

- پرسش سوم: بنظر شما و بر اساس تجربه به دست آمده، نوشتن آزمون پس از نوشتن برنامه، چه مشکلاتی را می‌تواند بسازد؟ اولین مشکلی که به آن برخوردم سازگار نبودن کد با آزمون‌های پیشین بود. اگر ابتدا آزمون‌ها را بنویسیم سپس برنامه، با یک نگاه جامع و بهتری می‌توانیم با مسئله مواجه شویم که خطا‌ها را کاهش می‌دهد و همچنین کد را بهینه می‌سازد. دومین مشکل پوشش ناکافی آزمون‌هاست. همانطور که دیدیم کد اصلی دارای باگ بود زیرا تست‌های مناسب از قبل نوشته نشده بودند (برای موجودی منفی). مشکل دیگر که پیش می‌آید refactor ضعیف کد است. همچنین اگر ابتدا کد را بنویسیم، ممکن است نگاه نقادانه را به موضوع از دست بدهیم و با فرض اینکه کد کامل است، آزمون‌های کافی یا مناسبی را طراحی نکنیم.

- پرسش چهارم: نوشتن موارد آزمون پیش از کدنویسی، چگونه کار ساخت برنامه را (نسبت به روش قبل که در بخش قبل انجام داده‌اید) تسهیل کرد؟ نوشتن کد برنامه شفاف‌تر بود و دوباره کاری لازم نبود. مورد دیگر این بود که کد بیشتر بهینه می‌شود و موارد اضافی یا روش‌های پیچیده‌ای که شاید لازم نباشد انجام نشد و در زمان صرفه جویی می‌شود. مورد آخر نیز اینکه بعنوان برنامه‌نویس از نهایی بودن سنجش و آزمون‌ها اطمینان داریم و با اعتماد به نفس صرفا کد برنامه را پیاده‌سازی می‌کنیم و ریفکتور می‌کنیم بدون اینکه به فکر اضافه شدن قابلیت جدید یا آزمون جدید باشیم.

- پرسش پنجم: در نهایت به نظر شما، روش ایجاد مبتنی بر آزمون چه مزایا و معایبی دارد؟

**مزایا**
  - طراحی و پیاده‌سازی برنامه شفاف و تمیزتر است. خوانش کد و تغییر آن نیز آسان‌تر است
  - کاهش باگ در روند پیاده‌سازی. رفتار‌ها از قبل مشخص هستند
  - سریع‌تر می‌توان کد زد. به نظرم اگر نوشتن کد از ارزیابی کد جدا بشه و در مراحل متفواوتی (یا توسط افراد متفاوتی انجام بشه) می‌توان با تمرکز بیشتر بر نوشتن کد سریع‌تر برنامه‌نویسی کرد.
  - کد ماژولار می‌شود. در طول زمان نیز می‌توان به راحتی تغییرش داد زیرا احتمال اینکه نیازمندی‌ها تغییر کنند کمتر و دیرتر است.
  - نگهداری کد بهتر می‌شود

**معایب**
  - شروع کند. ابتدا تیم باید نوشتن کد و ارتباط با سایر اعضای تیم از طریق آزمون‌پذیری کد را بیاموزد که در اوایل کار زمان‌بر است.
  - اگر تست‌ها مناسب نباشند و خیلی جزئی شوند، با هر بار ریفکتور شکست می‌خورند.
  - بخش‌هایی وجود دارند که قابل آزمون گرفتن نیستند. مانند رابط کاربری بصری.
  - ممکن است نیازمندی‌ها تغییرات زیادی کنند که سبب شود آزمون‌های پایداری نداشته باشیم.
  - ممکن است برای برنامه‌نویس محدودیت ایجاد کند. مثلا الگوریتمی که با یک روش خلاقانه می‌شود در یک ثانیه اجرا شود، به سبب شکسته شدن برای گذراندن صحیح آزمون‌ها کندتر شود و بهینه نباشد.
</div>
