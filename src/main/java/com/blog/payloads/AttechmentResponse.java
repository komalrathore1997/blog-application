package com.blog.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttechmentResponse {
 
    private String fileName;
    private String fileType;
    private String downloadUrl;
    private long fileSize;
    
}
