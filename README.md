# Design Token

## Mapping with default design tokens

        <!--Headers-->
        <item name="textAppearanceHeadlineLarge">@style/Heading.L</item>
        <item name="textAppearanceHeadlineMedium">@style/Heading.M</item>
        <item name="textAppearanceHeadlineSmall">@style/Heading.S</item>
        <item name="textAppearanceHeadline6">@style/Heading.XS</item>
        <!--Labels-->
        <item name="textAppearanceBodyLarge">@style/Label.L</item>
        <item name="textAppearanceBodyMedium">@style/Label.M</item>
        <item name="textAppearanceBodySmall">@style/Label.S</item>

        <!--paragraph-->
        <item name="textAppearanceLabelLarge">@style/Paragraph.L</item>
        <item name="textAppearanceLabelMedium">@style/Paragraph.M</item>
        <item name="textAppearanceLabelSmall">@style/Paragraph.S</item>


### Smale Usage

            <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:text="@string/label_small"
                android:textAppearance="?attr/textAppearanceBodySmall" />

