<div dir="rtl">
  
  با اجرای `JavaCup` و وارد کردن ۳ عدد ارور `java.lang.OutOfMemoryError: Java heap space` را می‌گیریم.
  با بررسی میزان مصرف حافظه در پروفایلینگ **YourKit** مشخص است که هنگام فراخوانی تابع `JavaCup.temp` این اتفاق روی داده است.
<img width="1548" alt="Screenshot 2025-05-09 at 9 54 32 PM" src="https://github.com/user-attachments/assets/2be55d76-892b-4eb7-ba9a-efa4e7bff4b1" />
برای بهبود عملکرد تابع `add` در آرایه `initialCapacity` را موقع ساخت آرایه ست می‌کنیم تا بیش از نیازمان فضا به آرایه اختصاص داده نشود (به دلیل دوبرابر شدن آرایه ممکن است مقدار درخواستی بیش از نیاز باشد).

</div>
