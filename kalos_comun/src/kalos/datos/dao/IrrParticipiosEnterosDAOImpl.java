
 A d d R e g                       =   G C R 4 1 0 P . I n s t a l l . A d d R e g , R e a d e r . I n s t a l l . A d d R e g  
 C o p y F i l e s                 =   G C R 4 1 0 P . I n s t a l l . C o p y F i l e s  
  
 [ G C R 4 1 0 P . I n s t a l l . A d d R e g ]  
 H K R , ,   M a x i m a l B a u d R a t e , 0 x 0 0 0 1 0 0 0 1 , 3 8 4 0 0  
  
 [ G C R 4 1 0 P . I n s t a l l . C o p y F i l e s ]  
 g r s e r i a l . s y s , , , 2  
  
 [ G C R 4 1 0 P . I n s t a l l . N T . S e r v i c e s ]  
 A d d S e r v i c e   =   G C R 4 1 0 P ,   2 ,   G C R 4 1 0 P . S e r v i c e ,   G C R 4 1 0 P . E v e n t L o g  
  
 [ G C R 4 1 0 P . S e r v i c e ]  
 D i s p l a y N a m e           =   % G C R 4 1 0 P . D e v i c e D e s c %  
 S e r v i c e T y p e           =   1   ; % S E R V I C E _ K E R N E L _ D R I V E R %  
 S t a r t T y p e               =   3   ; % S E R V I C E _ A U T O _ S T A R T %  
 E r r o r C o n t r o l         =   1   ; % S E R V I C E _ E R R O R _ N O R M A L %  
 S e r v i c e B i n a r y       =   % 1 2 % \ g r s e r i a l . s y s  
  
 [ G C R 4 1 0 P . E v e n t L o g ]  
 A d d R e g   =   G C R 4 1 0 P . A d d E v e n t L o g . r e g  
  
 [ G C R 4 1 0 P . A d d E v e n t L o g . r e g ]  
 H K R , ,   E v e n t M e s s a g e F i l e ,   0 x 0 0 0 2 0 0 0 0 ,   " % % S y s t e m R o o t % % \ S y s t e m 3 2 \ d r i v e r s \ g r s e r i a l . s y s "  
 H K R , ,   T y p e s S u p p o r t e d ,       0 x 0 0 0 1 0 0 0 1 ,   7  
  
 [ D e s t i n a t i o n D i r s ]  
 G C R 4 1 0 P . I n s t a l l . C o p y F i l e s   =   1 2  
  
  
 ;   = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  
 ;   = = = = = = = = = = = = = = = = =   H P   r e a d e r s   = = = = = = = = = = = = = = = = = = = = =  
 ;   = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  
  
 [ H P . N T x 8 6 ]  
 ;   D i s p l a y N a m e                       S e c t i o n                       D e v i c e I d  
 ;   - - - - - - - - - - -                       - - - - - - -                       - - - - - - - -  
 % H P S C R 1 1 1 . D e v i c e D e s c %   =   H P S C R 1 1 1 . I n s t a l l ,   S E R E N U M \ S C M 0 0 0 9  
  
 [ H P S C R 1 1 1 . I n s t a l l . N T ]  
 A d d R e g                     =   R e a d e r . I n s t a l l . A d d R e g  
 C o p y F i l e s               =   S C M S C R 1 1 1 . I n s t a l l . C o p y F i l e s  
  
 [ H P S C R 1 1 1 . I n s t a l l . N T . H W ]  
 A d d R e g                     =   H P S C R 1 1 1 . I n s t a l l . A d d R e g . H W  
  
 [ H P S C R 1 1 1 . I n s t a l l . A d d R e g . H W ]  
 H K R , , " V e n d o r N a m e " , , " H e w l e t t   P a c k a r d "  
 H K R , , " I f d T y p e " , , " P r o t e c t T o o l s   S m a r t   C a r d   r e a d e r "  
  
 [ H P S C R 1 1 1 . I n s t a l l . N T . S e r v i c e s ]  
 A d d S e r v i c e   =   S C R 1 1 1 ,   2 ,   S C M S C R 1 1 1 . S e r v i c e ,   S C M S C R 1 1 1 . E v e n t L o g  
  
 ;   = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  
 ;   = = = = = = = = = = = = = = = = =   S c h l u m b e r g e r   r e a d e r s   = = = = = = = = = = = = = = = = = = = = =  
 ;   = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  
  
 [ S L B . N T x 8 6 ]  
 ;   D i s p l a y N a m e                       S e c t i o n                     D e v i c e I d  
 ;   - - - - - - - - - - -                       - - - - - - -                     - - - - - - - -  
 % S L B R E F L E X 2 0 . D e v i c e D e s c %   =             S L B R E F L E X 2 0 . I n s t a l l ,   P C M C I A \ P S C R - S L B _ R E F L E X _ 2 0 - 1 8 F 3  
 % S L B R E F L E X 3 0 . D e v i c e D e s c %   =             S L B R E F L E X 3 0 . I n s t a l l ,   P C M C I A \ R e f l e x _ 3 0 - s m a r t _ c a r d _ r e a d e r - E 8 = = = = = = = = =  
 ;   = = = = = = = = = = = = = = = = =   O M N I K E Y   r e a d e r s   = = = = = = = = = = = = = = = = = = = = =  
 ;   = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  
  
 [ O M N I K E Y . N T x 8 6 ]  
 ;   D i s p l a y N a m e                       S e c t i o n                     D e v i c e I d  
 ;   - - - - - - - - - - -                       - - - - - - -                     - - - - - - - -  
 % O M N C M B P . D e v i c e D e s c %   =     O M N C M B P . I n s t a l l ,   P C M C I A \ C a r d M a n - M o b i l e - 3 7 9 F  
 % O M N C M B P . D e v i c e D e s c %   =     O M N C M B P . I n s t a l l ,   P C M C I A \ C a r d M a n - 4 0 0 0 - 5 6 2 6  
 % O M N C M B P . D e v i c e D e s c %   =     O M N C M B P . I n s t a l l ,   P C M C I A \ S m a r t _ C a r d _ R e a d e r - P C - C a r d - 3 2 4 D  
 % O M N C X B P . D e v i c e D e s c %   =     O M N C X B P . I n s t a l l ,   P C M C I A \ O M N I K E Y - C a r d M a n _ 4 0 4 0 - F E 8 2  
  
 ;   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  
 ;   O M N I K E Y   P C M C I A   S m a r t   C a r d   R e a d e r  
 ;   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  
  
 [ O M N C M B P . I n s t a l l . N T ]  
 A d d R e g                     =   R e a d e r . I n s t a l l . A d d R e g  
 C o p y F i l e s               =   O M N C M B P . I n s t a l l . C o p y F i l e s  
  
 [ O M N C M B P . I n s t a l l . N T . H W ]  
 A d d R e g         =   O M N C M B P . I n s t a l l . A d d R e g . H W  
  
 [ O M N C M B P . I n s t a l l . A d d R e g . H W ]  
 H K R , , " V e n d o r N a m e " , , " O M N I K E Y "  
 H K R , , " I f d T y p e " , ,   " C a r d M a n   4 0 0 0 "  
  
 [ O M N C M B P . I n s t a l l . C o p y F i l e s ]  
 c m b p 0 w d m . s y s , , , 2  
  
 [ O M N C M B P . I n s t a l l . N T . S e r v i c e s ]  
 A d d S e r v i c e   =   O M N C M B P ,   2 ,   O M N C M B P . S e r v i c e ,   O M N C M B P . E v e n t L o g  
  
 [ O M N C M B P . S e r v i c e ]  
 D i s p l a y N a m e           =   % O M N C M B P . D e v i c e D e s c %  
 S e r v i c e T y p e           =   1   ; % S E R V I C E _ K E R N E L _ D R I V E R %  
 S t a r t T y p e               = 