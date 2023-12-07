package com.bhas.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.bhas.entity.BookEntity;

@Configuration
public class BatchConfig 
{

	@Bean
	public Job bookReaderJob(JobRepository jobRepository, PlatformTransactionManager transactionManager)
	{
		return new JobBuilder("bookReadJob", jobRepository)
				.incrementer(new RunIdIncrementer())
				.start()
				.build();
	}
	
	@Bean
	public Step chunkStep(JobRepository jobRepository, PlatformTransactionManager transactionManager)
	{
		return new StepBuilder("bookReaderStep",jobRepository).<BookEntity,BookEntity>chunk(10,transactionManager)
				.reader()
				.processor()
				.writer()
				.build();
	}
	
	@Bean
	@StepScope
	public FlatFileItemReader<BookEntity> reader()
	{
		return new FlatFileItemReader<BookEntity>()
				.name("bookReader")
				.resource(new ClassPathResource(""))
				.delimited()
				.names(new String[] {})
				
				.build();
	}
}
